package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateTrainSet {

    private Locomotive randomLocomotive;

    // Randomly choosing a locomotive for a trainset one locomotive can be in one trainset !!!!!! in progress
  private void addRandomLocomotive(List<Locomotive> allLocomotives) {
      Random rand = new Random();
      while(allLocomotives.size() > 0) {
          int index = rand.nextInt(allLocomotives.size());
          allLocomotives.remove(index);
      }
      System.out.println(allLocomotives);
  }

    // Method to get the chosen locomotive's Max Load Weight
    private Integer getLocoMaxLoadWeight(Locomotive locomotive) {
        return locomotive.getMaxLocoLoadWeight();
    }

    // Method to get the chosen locomotive's Maximum Cars that can be attached
    private Integer getLocoMaxCarNumber(Locomotive locomotive) {
        return locomotive.getMaxNumberCars();
    }

    // Adding cars to a trainset based on chosen locomotive's limits
    private List<Cars> addRandomCars(List<Cars> allCars) {
        Integer maxLoadInTrainset = getLocoMaxLoadWeight(randomLocomotive);
        Integer maxNumCarsInTrainset = getLocoMaxCarNumber(randomLocomotive);
        List<Cars> carsInTrainSet = new ArrayList<Cars>();

        // assigning
        while (maxLoadInTrainset > 0 && carsInTrainSet.size() < maxNumCarsInTrainset) {
            Cars randomCar = allCars.get((int) (Math.random() * allCars.size()));
            if (getLocoMaxLoadWeight(randomLocomotive) >= randomCar.getGrossWeight()) {
                carsInTrainSet.add(randomCar);
                maxLoadInTrainset -= randomCar.getGrossWeight();
            }
        }

        return carsInTrainSet;
    }

    public void createTrainSetRandomly(List<Locomotive> allLocomotives, List<Cars> allCars) {
        addRandomLocomotive(allLocomotives);
        addRandomCars(allCars);
    }


}
