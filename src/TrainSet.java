import java.util.List;

public class TrainSet {
    private List<Cars> cars;
    private Locomotive locomotive;

    public void addRandomLocomotive(List<Locomotive> allLocomotives) {
        locomotive = allLocomotives.get((int) (Math.random() * allLocomotives.size()));
    }

    // create a list of locomotives and railroad cars
//    List<Locomotive> allLocomotives = new ArrayList<>();
//allLocomotives.add(new Locomotive("ABC123", 1000));
//
//    List<RailroadCar> allCars = new ArrayList<>();
//allCars.add(new Boxcar(500));
//allCars.add(new TankCar(750));
//allCars.add(new Flatcar(1000));
//
//    // create a new trainset and add a random locomotive and random cars
// Trainset myTrainset = new Trainset();
//myTrainset.addRandomLocomotive(allLocomotives);
//myTrainset.addRandomCars(allCars, 5);
//
//// print the trainset
//myTrainset.printTrainset();


}
