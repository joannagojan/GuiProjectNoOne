package Railway.Functionalities.Routes;

import java.util.ArrayList;
import java.util.List;

public class MovingTrainsets extends Thread{
    private List<Station> bestPath = new ArrayList<>();
    private Trainset trainset;

    public MovingTrainsets(Trainset trainset) {
        this.trainset = trainset;
        this.bestPath = GetBestPath(trainset);
    }

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

    public MovingTrainsets(List<Station> bestPath){
        this.bestPath = bestPath;
    }
    @Override
    public void run() {

    }
}
