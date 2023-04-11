import java.util.ArrayList;
import java.util.List;

public class TrainSet {
    private Locomotive randomLocomotive;
    private List<Cars> carsInTrainSet = new ArrayList<>();


    // Randomly choosing a locomotive for a trainset
    private Locomotive addRandomLocomotive(List<Locomotive> allLocomotives) {
        randomLocomotive = allLocomotives.get((int) (Math.random() * allLocomotives.size()));
        return randomLocomotive;
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
    private void addRandomCars(List<Cars> allCars) {
        Integer maxLoadInTrainset = getLocoMaxLoadWeight(randomLocomotive);
        Integer maxNumCarsInTrainset = getLocoMaxCarNumber(randomLocomotive);

        // assigning
        while (maxLoadInTrainset > 0 && carsInTrainSet.size() < maxNumCarsInTrainset) {
            Cars randomCar = allCars.get((int) (Math.random() * allCars.size()));
            if (getLocoMaxLoadWeight(randomLocomotive) >= randomCar.getGrossWeight()) {
                carsInTrainSet.add(randomCar);
                maxLoadInTrainset -= randomCar.getGrossWeight();
            }
        }
    }


}
