import java.util.ArrayList;
import java.util.List;

public class TrainSet {
    private List<Cars> cars;
    private Locomotive randomLocomotive;
    private List<Locomotive> allLocomotives = new ArrayList<>();
    private List<Cars> cars = new ArrayList<>();


    public void addRandomLocomotive(List<Locomotive> allLocomotives) {
        randomLocomotive = allLocomotives.get((int) (Math.random() * allLocomotives.size()));

    }

    public void addRandomCars(List<Cars> allCars) {
        int maxLoad = randomLocomotive.get;

        while (maxLoad > 0 && cars.size() < maxNumCars) {
            RailroadCar randomCar = allCars.get((int) (Math.random() * allCars.size()));
            if (maxLoad >= randomCar.getWeight()) {
                cars.add(randomCar);
                maxLoad -= randomCar.getWeight();
            }
        }
    }
//    // create a new trainset and add a random locomotive and random cars
// Trainset myTrainset = new Trainset();
//myTrainset.addRandomLocomotive(allLocomotives);
//myTrainset.addRandomCars(allCars, 5);
//
//// print the trainset
//myTrainset.printTrainset();


}
