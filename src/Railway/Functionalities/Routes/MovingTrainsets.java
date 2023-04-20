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

    // for printing information
    private double percentDistanceCompleted;
    private double percentDistanceToNearestStations;



    public MovingTrainsets(Trainset trainset, List<Trainset> allTrainsets) {
        this.trainset = trainset;
        this.bestPathStartToFinish = GetBestPath(trainset, trainset.getTrainsetStartStation(), trainset.getTrainsetEndStation());
        this.bestPathFinishToStart = GetBestPath(trainset, trainset.getTrainsetEndStation(), trainset.getTrainsetStartStation());
        this.allTrainsets = allTrainsets;
        this.percentDistanceCompleted = 0;
        this.percentDistanceToNearestStations = 0;


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
            List<Station> bestRoute = bestPathStartToFinish; // Get the best route for the trainset
            int currentStationIndex = 0;
            int nextStationIndex = 1;
            int totalNumberOfStations = bestRoute.size();
            boolean returnJourney = false;
            Thread speedChangeThread = new Thread(new SpeedChangeRunnable());
            speedChangeThread.start();

            while (nextStationIndex < bestRoute.size()) {

                while (nextStationIndex < bestRoute.size()) {
                    Station currentStation = bestRoute.get(currentStationIndex);
                    Station nextStation = bestRoute.get(nextStationIndex);

                    boolean roadFree = true;

//            // Check if the trainset ID matches the desired ID (5)
//            if (trainset.getTrainsetID() == 1 ) {
//                System.out.println("Train ID: " + trainset.getTrainsetID());
//                System.out.println("Start station: " + trainset.getTrainsetStartStation());
//                System.out.println("Current Station: " + currentStation.getName());
//                System.out.println("Next Station: " + nextStation.getName());
//                System.out.println("Route: " + bestRoute);
//            }

                    if (roadFree) {
                        // Move train to next station at trainset's speed

                        try {
                            AtomicInteger speedAtomic = new AtomicInteger(trainset.getSpeed().get());
                            int speed = speedAtomic.intValue() * 10; // so 200 km/h means 2000 miliseconds in real time
                            Thread.sleep(speed); // Sleep for the duration of trainset's speed to simulate movement
                            System.out.println("Train id: " + trainset.getTrainsetID() +
                                    " between: " + currentStation.getName() + " and: " + nextStation.getName()
                            );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Update station indices
                        currentStationIndex++;
                        nextStationIndex++;

                        synchronized (currentStation) {
                            currentStation.setOccupied(false);
                        }
                        synchronized (nextStation) {
                            nextStation.setOccupied(false);
                        }
                        synchronized (currentStation) {
                            // Check if the road between currentStation and nextStation is free
                            if (!currentStation.isOccupied() && !nextStation.isOccupied()
                                    && !trainset.getTrainsetID().equals(currentStation.getOccupyingTrainID())
                                    && !trainset.getTrainsetID().equals(nextStation.getOccupyingTrainID())
                            ) {
                                if (!currentStation.isOccupied()) {
                                    System.out.println("station id: " + currentStation.getName() + "train occup: " + currentStation.getOccupyingTrainID());
                                }
                                currentStation.setOccupied(true);
                                currentStation.setOccupyingTrainID(trainset.getTrainsetID());
                                nextStation.setOccupied(true);
                                nextStation.setOccupyingTrainID(trainset.getTrainsetID());
                                roadFree = true;
                            }
                        }

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

                    // Train has reached the destination, update its status
                    trainset.setReachedDestination(true);

                    if (trainset.isReachedDestination() && !returnJourney) {
                        try {
                            Thread.sleep(30000); // Sleep for 30 seconds
                            System.out.println("This train has reached its destination, id: " + trainset.getTrainsetID());

                            // Reset the parameters for the next run
                            bestRoute.addAll(bestPathFinishToStart);
                            currentStationIndex = 0;
                            nextStationIndex = 1;
                            trainset.setReachedDestination(false); // Reset the flag for the next run
                            returnJourney = true;

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
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




//    public void sortTrainsetsByRouteLength(List<Trainset> trainsets) {
//        Collections.sort(trainsets, (train1, train2) -> {
//            Integer routeLengthT1 = train1.getSizeOfRoute();
//            Integer routeLengthT2 = train2.getSizeOfRoute();
//            return Integer.compare(routeLengthT2, routeLengthT1);
//        });
//    }


    public void appStateFile() {
//        sortTrainsetsByRouteLength(allTrainsets);
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Sleep for 5 seconds
                    StringBuilder sb = new StringBuilder();

                    for (Trainset trainset : allTrainsets) {
//                        trainset.sortCarsByWeight(); // Sort railroad cars in the trainset by weight
                        sb.append("Trainset ID: ").append(trainset.getTrainsetID()).append("\n");
                        sb.append("Speed: ").append(trainset.getSpeed()).append("\n");
                        sb.append("Route Length: ").append(trainset.getSizeOfRoute()).append("\n");
                        sb.append("Railroad Cars (sorted by weight):\n");

                        for (Cars railroadCar : trainset.getTrainsetCars()) {
                            sb.append("  Car ID: ").append(railroadCar.getCarID()).append(", Weight: ")
                                    .append(railroadCar.getGrossWeight()).append("\n");
                        }

                        sb.append("---------------\n");
                    }


                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("AppState.txt"))) {
                        writer.write(sb.toString());
                        writer.close();
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
