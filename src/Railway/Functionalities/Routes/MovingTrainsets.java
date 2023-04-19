package Railway.Functionalities.Routes;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.Queue;

public class MovingTrainsets implements Runnable  {
    private List<Station> bestPath = new ArrayList<>();
    private Trainset trainset;
    private List<Route> occupiedRoutes = new ArrayList<>();

    public MovingTrainsets(Trainset trainset) {
        this.trainset = trainset;
        this.bestPath = GetBestPath(trainset);
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
        return fromSourceToStartBestPath;
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
            synchronized (currentStation) {
                // Check if the road between currentStation and nextStation is free
                if (!currentStation.isOccupied() && !nextStation.isOccupied()) {
                    currentStation.setOccupied(true);
                    nextStation.setOccupied(true);
                    roadFree = true;
                }
            }

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

                // Queueing trains that are waiting for the route to clear
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
                // Adding the train to the queue
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

    public void setTrainset(Trainset trainset) {
        this.trainset = trainset;
    }
}
