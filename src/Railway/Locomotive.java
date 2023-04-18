package Railway;

import Railway.Functionalities.Routes.Station;

import java.util.concurrent.atomic.AtomicInteger;

public class Locomotive {
    private String locomotiveName;
    private Station locoStartStation; // Starting station
    private Station sourceStation; // home station of the locomotive
    private Station locoDestinationStation;
    private Integer maxNumberCars; // maximum number of cars that can be connected to a locomotive object
    private Integer maxLocoLoadWeight; // maximum load a locomotive object can carry
    private Integer locomotiveSpeed; // assigned speed to a locomotive object

    private static final AtomicInteger locomotiveIDCounter = new AtomicInteger(0);
    private final Integer locomotiveID;
private Integer trainsetID;
    private Integer maxElectricCarsConnected;

    // range of locomotive Load range
    private final Integer minLocoLoadRange = 5000;// in tons
    private final Integer maxLocoLoadRange = 30000; // in tons

    //Construtor of Railway.Locomotive class
    public Locomotive(String locomotiveName, Station sourceStation, Station locoStartStation, Station locoDestinationStation,
                      Integer maxNumberCars, Integer maxLocoLoadWeight,
                      Integer locomotiveSpeed, Integer maxElectricCarsConnected) throws Exception {
        // max weight of the load
        if (maxLocoLoadWeight < minLocoLoadRange || maxLocoLoadWeight > maxLocoLoadWeight) {
            throw new Exception("Maximum load weight must be in range of " +
                   + minLocoLoadRange + "-" + maxLocoLoadWeight + " tons ");}
        this.locomotiveID = locomotiveIDCounter.incrementAndGet();
        this.sourceStation = sourceStation;
        this.locomotiveName = locomotiveName;
        this.locoStartStation = locoStartStation;
        if (locoDestinationStation.equals(locoStartStation) || locoDestinationStation.equals(sourceStation)) {
            throw new Exception("Destination station has to be different than Start and Source stations ");}
        this.locoDestinationStation = locoDestinationStation;
        this.maxNumberCars = maxNumberCars;
        this.maxLocoLoadWeight = maxLocoLoadWeight;
        this.locomotiveSpeed = locomotiveSpeed;
        this.maxElectricCarsConnected = maxElectricCarsConnected;

    }

    // toString for printing information about Railway.Locomotive class
    @Override
    public String toString() {
        return "This is locomotive number " + locomotiveID + " called " + locomotiveName + " it departs from " + locoStartStation
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

    public Station getLocoStartStation() {
        return locoStartStation;
    }

    public void setLocoStartStation(Station locoStartStation) {
        this.locoStartStation = locoStartStation;
    }

    public Station getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(Station sourceStation) {
        this.sourceStation = sourceStation;
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

    public Integer getMinLocoLoadRange() {
        return minLocoLoadRange;
    }

    public Integer getMaxLocoLoadRange() {
        return maxLocoLoadRange;
    }
}
