package Railway;

import Railway.CarTypes.Cars;

import java.util.List;

public class Locomotive {

    private Integer locomotiveID;
    private String locomotiveName;
    private Station locoHomeStation;
    private Station locoDestinationStation;
    private static Integer maxNumberCars; // maximum number of cars that can be connected to a locomotive object
    private static Integer maxLocoLoadWeight; // maximum load a locomotive object can carry
    private Integer locomotiveSpeed; // assigned speed to a locomotive object

    private static Integer locomotiveIDCounter = 0;



    //Construtor of Railway.Locomotive class
    public Locomotive(String locomotiveName, Station locoHomeStation, Station locoDestinationStation,
                      Integer maxNumberCars, Integer maxLocoLoadWeight,
                      Integer locomotiveSpeed) {
        // max weight of the load cannot be smaller than 5000 tons and bigger than 13000 tons
        if (maxLocoLoadWeight < 5000 || maxLocoLoadWeight < 13000) {
            throw new IllegalArgumentException("Maximum load weight must be in range of 5000-13000 tons ");
        }

        this.locomotiveID = ++locomotiveIDCounter; // automatic ID counter with every created object
        this.locomotiveName = locomotiveName;
        this.locoHomeStation = locoHomeStation;
        this.locoDestinationStation = locoDestinationStation;
        Locomotive.maxNumberCars = maxNumberCars;
        this.maxLocoLoadWeight = maxLocoLoadWeight;
        this.locomotiveSpeed = locomotiveSpeed;

    }

    // toString for printing information about Railway.Locomotive class
    @Override
    public String toString() {
        return "This is locomotive number " + locomotiveID + " called " + locomotiveName + " it departs from " + locoHomeStation
                + "with a destination in " + locoDestinationStation +
                " with maximum number of cars of " + maxNumberCars + " and maximum weight load "
                + maxLocoLoadWeight + " of the speef of "
                + locomotiveSpeed  + '.';
    }

    public Integer getMaxNumberCars() {
        return maxNumberCars;
    }

    public static void setMaxNumberCars(Integer maxNumberCars) {
        Locomotive.maxNumberCars = maxNumberCars;
    }

    public Integer getMaxLocoLoadWeight() {
        return maxLocoLoadWeight;
    }

    public static void setMaxLocoLoadWeight(Integer maxLocoLoadWeight) {
        Locomotive.maxLocoLoadWeight = maxLocoLoadWeight;
    }

    public static class TrainSet {
        private Locomotive randomLocomotive;
        private List<Cars> carsInTrainSet;

        public TrainSet(Locomotive randomLocomotive, List<Cars> carsInTrainSet) {
            this.randomLocomotive = randomLocomotive;
            this.carsInTrainSet = carsInTrainSet;
        }
    }
}
