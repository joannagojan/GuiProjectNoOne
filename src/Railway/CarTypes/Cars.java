package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Cars {
    private static final AtomicInteger carIDCounter = new AtomicInteger(0);
    private final Integer carID;
    private static Integer carWidth = 240; // Standard Car width in cm
    private static Integer carHeight = 260; // Standard Car height in cm
    private static Integer carLength = 1500; // Standard Car width in cm
    private static Integer standardMaxCarLoad = 100; // Standard Car maximum load in tons (for all classes except Heavy Freight)
    private static Integer standardNetWeight = 50000; // Standard Net Weight of a car in kgs


    // constructor that automatically assigns ID number to new Objects of all Car classes
    public Cars() {

        this.carID = carIDCounter.incrementAndGet();
    }
    public abstract Integer getGrossWeight();

    // determining the need to connect to electricity
    public abstract boolean requiredElectricity();

    public Integer getCarID() {
        return carID;
    }


    public static Integer getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(Integer carWidth) {
        this.carWidth = carWidth;
    }

    public static Integer getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(Integer carHeight) {
        this.carHeight = carHeight;
    }

    public static Integer getCarLength() {
        return carLength;
    }

    public void setCarLength(Integer carLength) {
        this.carLength = carLength;
    }

    public static Integer getStandardMaxCarLoad() {
        return standardMaxCarLoad;
    }

    public void setCarWeight(Integer carWeight) {
        this.standardMaxCarLoad = carWeight;
    }

    public static Integer getStandardNetWeight() {
        return standardNetWeight;
    }
    public static void setStandardNetWeight(Integer standardNetWeight) {
        Cars.standardNetWeight = standardNetWeight;
    }
}
