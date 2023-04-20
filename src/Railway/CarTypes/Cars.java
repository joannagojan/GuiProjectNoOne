package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Cars {
    private static final AtomicInteger carIDCounter = new AtomicInteger(0);
    private final Integer carID;
    private final static Integer CAR_WIDTH = 240; // Standard Car width in cm
    private final static Integer CAR_HEIGHT = 260; // Standard Car height in cm
    private final static Integer CAR_LENGTH = 1500; // Standard Car width in cm
    private final static Integer STANDARD_MAX_CAR_LOAD = 100; // Standard Car maximum load in tons (for all classes except Heavy Freight)
    private final static Integer STANDARD_NET_WEIGHT = 5000; // Standard Net Weight of a car in kgs
    private Integer trainsetID;


    // constructor that automatically assigns ID number to new Objects of all Car classes
    public Cars() {
        this.carID = carIDCounter.incrementAndGet();
    }


    public Integer getTrainsetID() {
        return trainsetID;
    }

    public void setTrainsetID(Integer trainsetID) {
        this.trainsetID = trainsetID;
    }

    public abstract Integer getGrossWeight();

    // determining the need to connect to electricity
    public abstract boolean requiredElectricity();

    public Integer getCarID() {
        return carID;
    }


    public static Integer getCarWidth() {
        return CAR_WIDTH;
    }



    public static Integer getCarHeight() {
        return CAR_HEIGHT;
    }


    public static Integer getCarLength() {
        return CAR_LENGTH;
    }


    public static Integer getStandardMaxCarLoad() {
        return STANDARD_MAX_CAR_LOAD;
    }

    public static Integer getStandardNetWeight() {
        return STANDARD_NET_WEIGHT;
    }

}
