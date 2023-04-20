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
    private AtomicInteger locomotiveSpeed; // assigned speed to a locomotive object

    private static final AtomicInteger locomotiveIDCounter = new AtomicInteger(0);
    private final Integer locomotiveID;
    private Integer trainsetID;
    private Integer maxElectricCarsConnected;

    // range of locomotive Load range
    private final Integer minLocoLoadRange = 15000;// in tons
    private final Integer maxLocoLoadRange = 30000; // in tons
    // range of how many Cars can require connection to electricity grid
    private Integer minElectricConnected = 0;
    private Integer maxElectricConnected = 10;

    // range for number of cars connected to the Locomotive
    private Integer minRangeNumberOfCars = 1;
    private Integer maxRangeNumberOfCars = 10;

    // range for Locomotive's speed in km/h
    private AtomicInteger minRangeSpeed = new AtomicInteger(100);
    private  AtomicInteger maxRangeSpeed = new AtomicInteger(250);

    //Construtor of Railway.Locomotive class
    public Locomotive(String locomotiveName, Station sourceStation, Station locoStartStation, Station locoDestinationStation,
                      Integer maxNumberCars, Integer maxLocoLoadWeight,
                      AtomicInteger locomotiveSpeed, Integer maxElectricCarsConnected) throws Exception {
        // max weight of the load
        if (maxLocoLoadWeight < minLocoLoadRange || maxLocoLoadWeight > maxLocoLoadWeight) {
            throw new Exception("Maximum load weight must be in range of " +
                    +minLocoLoadRange + "-" + maxLocoLoadWeight + " tons ");
        }
        else {
            this.maxLocoLoadWeight = maxLocoLoadWeight;
        }
        if (locomotiveSpeed.get() < minRangeSpeed.get() || locomotiveSpeed.get() > maxRangeSpeed.get()) {
            throw new Exception("Maximum load weight must be in range of " +
                    +minRangeSpeed.get() + "-" + maxRangeSpeed.get() + " km/h, and you provided speed: " + locomotiveSpeed.get());
        }
        else {
            this.maxLocoLoadWeight = maxLocoLoadWeight;
        }
        this.locomotiveID = locomotiveIDCounter.incrementAndGet();
        this.sourceStation = sourceStation;
        this.locomotiveName = locomotiveName;
        this.locoStartStation = locoStartStation;
        if (locoDestinationStation.equals(locoStartStation) || locoDestinationStation.equals(sourceStation)) {
            throw new Exception("Destination station has to be different than Start and Source stations ");
        } else {
            this.locoDestinationStation = locoDestinationStation;
        }
        if (maxNumberCars < minRangeNumberOfCars || maxNumberCars > maxRangeNumberOfCars) {
            throw new Exception("Maximum possible connected cars to this locomotive must be in range: " +
                    +minRangeNumberOfCars + "-" + maxRangeNumberOfCars);
        } else {
            this.maxNumberCars = maxNumberCars;
        }
        this.locomotiveSpeed = locomotiveSpeed;
        if (maxElectricCarsConnected < minElectricConnected || maxElectricCarsConnected > maxElectricCarsConnected) {
            throw new Exception("Maximum possible connected cars to electricity must be in range: " +
                    +minElectricConnected + "-" + maxElectricCarsConnected);
        }
        else {
            this.maxElectricCarsConnected = maxElectricCarsConnected;
        }
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

    public AtomicInteger getLocomotiveSpeed() {
        return locomotiveSpeed;
    }

    public void setLocomotiveSpeed(AtomicInteger locomotiveSpeed) {
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

    @Override
    public String toString() {
        return "Locomotive of ID: " + locomotiveID +
                "of name: " + locomotiveName +
                ", it's start station is: " + locoStartStation +
                ", it's source station is:" + sourceStation +
                ", it's destination station is:" + locoDestinationStation +
                ", it's current speed=" + locomotiveSpeed ;
    }

}
