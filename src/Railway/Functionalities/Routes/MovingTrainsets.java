package Railway.Functionalities.Routes;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.Queue;


public class MovingTrainsets implements Runnable  {
    private List<Station> bestPath = new ArrayList<>();
    private Trainset trainset;
    private List<Route> occupiedRoutes = new ArrayList<>();
    private List<Trainset> allTrainsets;

    private boolean reachedDestination = false;
    public MovingTrainsets(Trainset trainset, List<Trainset> allTrainsets) {
        this.trainset = trainset;
        this.bestPath = GetBestPath(trainset);
        this.allTrainsets = allTrainsets;
    }

    // Calculating best path using Dijkstra's algorithm
    public List<Station> GetBestPath(Trainset trainset) {
        Station startStation = trainset.getTrainsetStartStation();
        Station endStation = trainset.getTrainsetEndStation();
        Station sourceStation = trainset.getTrainsetSourceStation();
        GetBestRoute shortestPath = new GetBestRoute();
        shortestPath.getBestRoute(sourceStation);
        List<Station> fromSourceToStartBestPath = shortestPath.getShortestPathTo(startStation);
        System.out.println("this trainsets : " + trainset.getTrainsetID()
                + " best path from source to start is: "
        );
        for (Station station : fromSourceToStartBestPath) {
            System.out.println(station);
        }
        shortestPath.getBestRoute(startStation);
        List<Station> fromStartToEndBestPath = shortestPath.getShortestPathTo(endStation);
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
        List<Station> bestRoute = bestPath; // Get the best route for the trainset
        int currentStationIndex = 0;
        int nextStationIndex = 1;

        while (nextStationIndex < bestRoute.size()) {
            Station currentStation = bestRoute.get(currentStationIndex);
            Station nextStation = bestRoute.get(nextStationIndex);
            boolean roadFree = false;
//            synchronized (currentStation) {
//                // Check if the road between currentStation and nextStation is free
//                if (!currentStation.isOccupied() && !nextStation.isOccupied()) {
//                    currentStation.setOccupied(true);
//                    nextStation.setOccupied(true);
//                    if (nextStation.isOccupied()) {
//                        System.out.println(nextStation.getName() + " is occupied, by trainset id: " + trainset.getTrainsetID());
//                    }
//                    roadFree = true;
//                }
//            }
            // Check if the trainset ID matches the desired ID (5)
            if (trainset.getTrainsetID() == 5) {
                System.out.println("Train ID: " + trainset.getTrainsetID());
                System.out.println("Start station: " + trainset.getTrainsetStartStation());
                System.out.println("Current Station: " + currentStation.getName());
                System.out.println("Next Station: " + nextStation.getName());
                System.out.println("Route: " + bestRoute);
            }

            roadFree = true;
            if (roadFree) {
                // Move train to next station at trainset's speed
                int speed = trainset.getSpeed();
                try {
                    Thread.sleep(speed); // Sleep for the duration of trainset's speed to simulate movement
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

                // Check if there are trainsets waiting in the queue
                synchronized (MovingTrainsets.class) {
                    if (!trainsetQueue.isEmpty()) {
                        Trainset nextTrainset = trainsetQueue.poll();
                        if (nextTrainset != null) {
                            trainset = nextTrainset;
                            bestRoute = bestPath;
                            currentStationIndex = 0;
                            nextStationIndex = 1;
                        }
                    }
                }
            } else {
                // Add the train to the queue
                synchronized (MovingTrainsets.class) {
                    trainsetQueue.offer(trainset);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Train has reached the destination, update its status
        trainset.setReachedDestination(true);
        if (trainset.isReachedDestination()) {
            System.out.println("This train has reached its destination, id: " + trainset.getTrainsetID());
        }
    }

    // Queue to hold awaiting trainsets
    private static Queue<Trainset> trainsetQueue = new LinkedList<>();

        public List<Station> getBestPath() {
            return bestPath;
        }

        public void setBestPath(List<Station> bestPath) {
            this.bestPath = bestPath;
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
