package Railway;

import java.util.concurrent.atomic.AtomicInteger;

public class Locomotive {
    private String locomotiveName;
    private Station locoHomeStation;
    private Station locoDestinationStation;
    private Integer maxNumberCars; // maximum number of cars that can be connected to a locomotive object
    private Integer maxLocoLoadWeight; // maximum load a locomotive object can carry
    private Integer locomotiveSpeed; // assigned speed to a locomotive object

    private static final AtomicInteger locomotiveIDCounter = new AtomicInteger(0);
    private final Integer locomotiveID;
private Integer trainsetID;
    private Integer maxElectricCarsConnected;

    //Construtor of Railway.Locomotive class
    public Locomotive(String locomotiveName, Station locoHomeStation, Station locoDestinationStation,
                      Integer maxNumberCars, Integer maxLocoLoadWeight,
                      Integer locomotiveSpeed, Integer maxElectricCarsConnected) {
        // max weight of the load cannot be smaller than 5000 tons and bigger than 13000 tons
        if (maxLocoLoadWeight < 5000 || maxLocoLoadWeight > 13000) {
            throw new IllegalArgumentException("Maximum load weight must be in range of 5000-13000 tons ");
        }

        this.locomotiveID = locomotiveIDCounter.incrementAndGet();
        this.locomotiveName = locomotiveName;
        this.locoHomeStation = locoHomeStation;
        this.locoDestinationStation = locoDestinationStation;
        this.maxNumberCars = maxNumberCars;
        this.maxLocoLoadWeight = maxLocoLoadWeight;
        this.locomotiveSpeed = locomotiveSpeed;
        this.maxElectricCarsConnected = maxElectricCarsConnected;

    }

    // toString for printing information about Railway.Locomotive class
    @Override
    public String toString() {
        return "This is locomotive number " + locomotiveID + " called " + locomotiveName + " it departs from " + locoHomeStation
                + "with a destination in " + locoDestinationStation +
                " with maximum number of cars of " + maxNumberCars + " and maximum weight load "
                + maxLocoLoadWeight + " of the speed of "
                + locomotiveSpeed  + '.';
    }


    public Integer getTrainsetID() {
        return trainsetID;
    }

    public void setTrainsetID(Integer trainsetID) {
        this.trainsetID = trainsetID;
    }
    public Integer getLocomotiveID() {
        return locomotiveID;
    }

    public String getLocomotiveName() {
        return locomotiveName;
    }

    public void setLocomotiveName(String locomotiveName) {
        this.locomotiveName = locomotiveName;
    }

    public Station getLocoHomeStation() {
        return locoHomeStation;
    }

    public void setLocoHomeStation(Station locoHomeStation) {
        this.locoHomeStation = locoHomeStation;
    }

    public Station getLocoDestinationStation() {
        return locoDestinationStation;
    }

    public void setLocoDestinationStation(Station locoDestinationStation) {
        this.locoDestinationStation = locoDestinationStation;
    }

    public Integer getMaxNumberCars() {
        return maxNumberCars;
    }

    public void setMaxNumberCars(Integer maxNumberCars) {
        this.maxNumberCars = maxNumberCars;
    }

    public Integer getMaxLocoLoadWeight() {
        return maxLocoLoadWeight;
    }

    public void setMaxLocoLoadWeight(Integer maxLocoLoadWeight) {
        this.maxLocoLoadWeight = maxLocoLoadWeight;
    }

    public Integer getLocomotiveSpeed() {
        return locomotiveSpeed;
    }

    public void setLocomotiveSpeed(Integer locomotiveSpeed) {
        this.locomotiveSpeed = locomotiveSpeed;
    }

    public Integer getMaxElectricCarsConnected() {
        return maxElectricCarsConnected;
    }

    public void setMaxElectricCarsConnected(Integer maxElectricCarsConnected) {
        this.maxElectricCarsConnected = maxElectricCarsConnected;
    }
}
