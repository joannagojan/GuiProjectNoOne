package Railway.Functionalities.Routes;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.Queue;


public class MovingTrainsets implements Runnable {
    private List<Station> bestPathStartToFinish = new ArrayList<>();
    private List<Station> bestPathFinishToStart = new ArrayList<>();
    private Trainset trainset;
    private List<Route> occupiedRoutes = new ArrayList<>();
    private List<Trainset> allTrainsets;

    private boolean reachedDestination = false;

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
        return fromStartToEndBestPath;
    }


    @Override
    public void run() {
        while (!trainset.isReachedDestination()) {
            List<Station> bestRoute = bestPathStartToFinish; // Get the best route for the trainset
            int currentStationIndex = 0;
            int nextStationIndex = 1;

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
                        int speed = trainset.getSpeed();
                        try {
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
                    if (trainset.isReachedDestination()) {
                        try {
                            Thread.sleep(30000); // Sleep for 30 seconds
                            System.out.println("This train has reached its destination, id: " + trainset.getTrainsetID());

                            // Reset the parameters for the next run
                            bestRoute.addAll(bestPathFinishToStart);
                            currentStationIndex = 0;
                            nextStationIndex = 1;
                            trainset.setReachedDestination(false); // Reset the flag for the next run

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }}


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
