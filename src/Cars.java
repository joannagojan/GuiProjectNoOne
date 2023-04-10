public abstract class Cars {
    private Integer carID;
    private static Integer carIDCounter = 0;
    private Integer carWidth = 240; // Standard Car width in cm
    private Integer carHeight = 260; // Standard Car height in cm
    private Integer carLength = 1500; // Standard Car width in cm
    private Integer carWeight = 100; // Standard Car maximum load in tons


    // constructor that automatically assigns ID number to new Objects of all Car classes


    public Cars(Integer carWidth, Integer carHeight, Integer carLength, Integer carWeight) {
        this.carID = ++carIDCounter;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.carLength = carLength;
        this.carWeight = carWeight;
    }

    // Child classes will calculate their own net weight of a car
    public abstract Integer getNetWeight();

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

    public Integer getCarHeight() {
        return carHeight;
    }

    public void setCarHeight(Integer carHeight) {
        this.carHeight = carHeight;
    }

    public Integer getCarLength() {
        return carLength;
    }

    public void setCarLength(Integer carLength) {
        this.carLength = carLength;
    }

    public Integer getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(Integer carWeight) {
        this.carWeight = carWeight;
    }
}
