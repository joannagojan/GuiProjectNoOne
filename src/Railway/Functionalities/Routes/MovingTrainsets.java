package Railway.Functionalities.Routes;

import Railway.CarTypes.Cars;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import java.util.concurrent.atomic.AtomicInteger;


public class MovingTrainsets implements Runnable {
    private List<Station> bestPathStartToFinish = new ArrayList<>();
    private List<Station> bestPathFinishToStart = new ArrayList<>();
    private Trainset trainset;
    private List<Route> occupiedRoutes = new ArrayList<>();
    private List<Trainset> allTrainsets;

    private boolean reachedDestination = false;
    private AtomicInteger speed;


    public MovingTrainsets(Trainset trainset, List<Trainset> allTrainsets) {
        this.trainset = trainset;
        this.bestPathStartToFinish = GetBestPath(trainset, trainset.getTrainsetStartStation(), trainset.getTrainsetEndStation());
        this.bestPathFinishToStart = GetBestPath(trainset, trainset.getTrainsetEndStation(), trainset.getTrainsetStartStation());
        this.allTrainsets = allTrainsets;


    }

    // Calculating best path using Dijkstra's algorithm
    public List<Station> GetBestPath(Trainset trainset, Station start, Station finish) {
        GetBestRoute shortestPath = new GetBestRoute();
        shortestPath.getBestRoute(start);
        List<Station> fromStartToEndBestPath = shortestPath.getShortestPathTo(finish);
        System.out.println("this trainsets: " + trainset.getTrainsetID()
                + " best path is: "
        );

        for (Station station : fromStartToEndBestPath) {
            System.out.println(station);
        }
        trainset.setSizeOfRoute(fromStartToEndBestPath.size());
        return fromStartToEndBestPath;
    }


    @Override
    public void run() {
        while (!trainset.isReachedDestination()) {
            List<Station> bestRoute = bestPathStartToFinish;
            int currentStationIndex = 0;
            int nextStationIndex = 1;
            boolean returnJourney = false;
            Thread speedChangeThread = new Thread(new SpeedChangeRunnable());
            speedChangeThread.start();

            while (nextStationIndex < bestRoute.size()) {

                Station currentStation = bestRoute.get(currentStationIndex);
                Station nextStation = bestRoute.get(nextStationIndex);

                synchronized (currentStation) {
                    if (!currentStation.isOccupied() && !nextStation.isOccupied()
                            && !trainset.getTrainsetID().equals(currentStation.getOccupyingTrainID())
                            && !trainset.getTrainsetID().equals(nextStation.getOccupyingTrainID())
                    ) {

                        currentStation.setOccupied(true);
                        currentStation.setOccupyingTrainID(trainset.getTrainsetID());
                        nextStation.setOccupied(true);
                        nextStation.setOccupyingTrainID(trainset.getTrainsetID());
                    }
                }

                try {
                    AtomicInteger speedAtomic = trainset.getSpeed();
                    int speed = speedAtomic.intValue() * 10; // so 200 km/h means 2000 milliseconds in real time
                    Thread.sleep(speed); // Moving train between stations
                    System.out.println("Train id: " + trainset.getTrainsetID() +
                            " is between " + currentStation.getName() + " and " + nextStation.getName()
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (currentStation) {
                    currentStation.setOccupied(false);
                }
                synchronized (nextStation) {
                    nextStation.setOccupied(false);
                }

                // Update station indices
                currentStationIndex++;
                nextStationIndex++;

                synchronized (MovingTrainsets.class) {
                    if (!trainsetQueue.isEmpty()) {
                        Trainset nextTrainset = trainsetQueue.poll();
                        if (nextTrainset != null) {
                            trainset = nextTrainset;
                            bestRoute = bestPathStartToFinish;
                            currentStationIndex = 0;
                            nextStationIndex = 1;
                        }
                    }
                }
            }

            trainset.setReachedDestination(true);
            if (trainset.isReachedDestination() && !returnJourney) {
                try {
                    Thread.sleep(30000); // Sleep for 30 seconds
                    System.out.println("This train has reached its destination, id: " + trainset.getTrainsetID());

                    bestRoute.addAll(bestPathFinishToStart);
                    currentStationIndex = 0;
                    nextStationIndex = 1;
                    trainset.setReachedDestination(false);
                    returnJourney = true;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private class SpeedChangeRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    AtomicInteger speed = trainset.getSpeed();
                    // Sleep for 1 second
                    Thread.sleep(1000);

                    // Randomly increase or decrease speed by 3%
                    int speedChange = (int) (Math.random() * 6) - 3; // Random value between -3 and 3
                    int speedPercentage = (speed.get() * speedChange) / 100;
                    speed.addAndGet(speedPercentage);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // Railroad Hazard exception when trainspeed is higher than 200 km/h
    public class SpeedChecker implements Runnable {

        Integer speed = MovingTrainsets.this.speed.intValue();

        @Override
        public void run() {
            while (true) {

                if (speed > 200) {
                    throw new RailroadHazard("Trains speed exceeds 200 km/h");
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        private static class RailroadHazard extends RuntimeException {
            public RailroadHazard(String message) {
                super(message);

            }
        }
    }



    // for printing in AppState file. Method to sort trainsets by the lenght of their best routes
    public void sortTrainsetsByRouteLength(List<Trainset> trainsets) {
        Collections.sort(trainsets, (train1, train2) -> {
            Integer routeLengthT1 = train1.getSizeOfRoute();
            Integer routeLengthT2 = train2.getSizeOfRoute();
            return Integer.compare(routeLengthT2, routeLengthT1);

        });
    }

// Adding current stats to AppState file
    public void appStateFile() {
        List<Trainset> sortedTrainsets = new ArrayList<>();
        sortedTrainsets.addAll(allTrainsets);
        sortTrainsetsByRouteLength(sortedTrainsets);
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    StringBuilder sb = new StringBuilder();

                    for (Trainset trainset : sortedTrainsets) {
                        sb.append("Trainsets sorted by route length:\n");
                        ArrayList<Cars> sortedCars = new ArrayList<>();
                        sortedCars.addAll(trainset.getTrainsetCars());
                        trainset.sortCarsByWeight(sortedCars); // Sort railroad cars in the trainset by weight
                        sb.append("Trainset ID: ").append(trainset.getTrainsetID()).append("\n");
                        sb.append("Trainset information").append(trainset);
                        sb.append("Route Length: ").append(trainset.getSizeOfRoute()).append("\n");
                        sb.append("Sorted Railroad cars:\n");

                        for (Cars railroadCar : sortedCars) {
                            sb.append("  Car ID: ").append(railroadCar.getCarID()).append(", Weight: ")
                                    .append(railroadCar.getGrossWeight()).append("\n");
                        }

                    }


                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("AppState.txt"))) {
                        writer.write(sb.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }
        });

        thread.start();
    }

// Method do display current information about a trainset based on ID
    public void displayInfo(Integer trainsetID) {
        Trainset trainset = null;
        for (Trainset trainset1 : allTrainsets) {
            if (trainset1.getTrainsetID().equals(trainsetID)) {
                trainset = trainset1;
                break;
            }
        }

        if (trainset == null) {
            System.out.println("Trainset not found");
            return;
        }

        System.out.println("Trainset ID: " + trainset.getTrainsetID());
        System.out.println("Trainset Start Station: " + trainset.getTrainsetStartStation().getName());
        System.out.println("Trainset End Station: " + trainset.getTrainsetEndStation().getName());
        for (Cars car : trainset.getTrainsetCars()) {
            System.out.println(car);
        }
    }


    // Queue to hold awaiting trainsets
    private static Queue<Trainset> trainsetQueue = new LinkedList<>();


    public List<Station> getBestPathStartToFinish() {
        return bestPathStartToFinish;
    }

    public void setBestPathStartToFinish(List<Station> bestPathStartToFinish) {
        this.bestPathStartToFinish = bestPathStartToFinish;
    }

    public Trainset getTrainset() {
        return trainset;
    }

    public boolean isReachedDestination() {
        return reachedDestination;
    }

    public void setReachedDestination(boolean reachedDestination) {
        this.reachedDestination = reachedDestination;
    }
}
