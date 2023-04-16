package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateTrainSet {

    private Integer locoMaxIndex; // number that shows how many locomotive objects are there

    // Method to get the chosen locomotive's Max Load Weight
    private Integer getLocoMaxLoadWeight(Locomotive locomotive) {
        return locomotive.getMaxLocoLoadWeight();
    }

    // Method to get the chosen locomotive's Maximum Cars that can be attached
    private Integer getLocoMaxCarNumber(Locomotive locomotive) {
        return locomotive.getMaxNumberCars();
    }

    // Adding cars to a trainset based on chosen locomotive's limits
//    private List<Cars> addRandomCars(List<Cars> allCars) {
//        Integer maxLoadInTrainset = getLocoMaxLoadWeight(randomLocomotive);
//        Integer maxNumCarsInTrainset = getLocoMaxCarNumber(randomLocomotive);
//        List<Cars> carsInTrainSet = new ArrayList<Cars>();
//        while (maxLoadInTrainset > 0 && carsInTrainSet.size() < maxNumCarsInTrainset) {
//            Cars randomCar = allCars.get((int) (Math.random() * allCars.size()));
//            if (getLocoMaxLoadWeight(randomLocomotive) >= randomCar.getGrossWeight()) {
//                carsInTrainSet.add(randomCar);
//                maxLoadInTrainset -= randomCar.getGrossWeight();
//            }
//        }
//
//        return carsInTrainSet;
//    }
//
//    public void createTrainSetRandomly(List<Locomotive> allLocomotives, List<Cars> allCars) {
//        addRandomLocomotive(allLocomotives);
//        addRandomCars(allCars);
//    }


}
