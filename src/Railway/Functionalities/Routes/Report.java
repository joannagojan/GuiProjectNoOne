//import Railway.Functionalities.Routes.Route;
//import Railway.Functionalities.Routes.Trainset;
//
//import java.util.List;
//
//public class TrainsetReportGenerator implements Runnable {
//
//    private MovingTrainsets movingTrainsets; // shared data structure
//
//    public TrainsetReportGenerator(MovingTrainsets movingTrainsets) {
//        this.movingTrainsets = movingTrainsets;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            // Access current information about trainsets using the shared data structure
//            synchronized (movingTrainsets) {
//                Trainset trainset = movingTrainsets.getTrainset();
//                List<String> bestPath = movingTrainsets.getBestPath();
//                int currentStationIndex = movingTrainsets.getCurrentStationIndex();
//                int nextStationIndex = movingTrainsets.getNextStationIndex();
//                List<Route> occupiedRoutes = movingTrainsets.getOccupiedRoutes();
//                List<Trainset> allTrainsets = movingTrainsets.getAllTrainsets();
//
//                // Generate reports using the current information about trainsets
//                // ...
//            }
//
//            // Sleep or perform other tasks as needed
//            try {
//                Thread.sleep(1000); // Sleep for 1 second
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
