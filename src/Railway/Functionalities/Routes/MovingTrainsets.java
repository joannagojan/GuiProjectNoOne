package Railway.Functionalities.Routes;

import java.util.List;

public class MovingTrainsets extends Thread{
    private List<Station> bestPath;

    public MovingTrainsets(List<Station> bestPath){
        this.bestPath = bestPath;
    }
    @Override
    public void run() {

    }
}
