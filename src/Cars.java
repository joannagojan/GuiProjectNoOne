public abstract class Cars {
    private Integer carID;
    private static Integer carIDCounter = 0;
    private static Integer carWidth = 240; // Standard Car width in cm
    private static Integer carHeight = 260; // Standard Car height in cm
    private static Integer carLength = 1500; // Standard Car width in cm
    private static Integer standardMaxCarLoad = 100; // Standard Car maximum load in tons (for all classes except Heavy Freight)


    // constructor that automatically assigns ID number to new Objects of all Car classes


    public Cars() {
        this.carID = ++carIDCounter;
    }

    // Child classes will calculate their own net weight of a car
    public abstract Integer getNetWeight();

    public abstract Integer getGrossWeight();

    // Child classes will calculate needed electricity based on other atributes
    public abstract Integer getHowMuchElectricity();

    // determining the need to connect to electricity
    public abstract boolean requiredElectricity();

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
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
}
