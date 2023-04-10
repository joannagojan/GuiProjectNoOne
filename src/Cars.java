public abstract class Cars {
    private Integer carID;
    private static Integer carIDCounter = 0;

    // automaticly assigns ID number to new Objects of all Car classes
    public Cars() {
        this.carID = ++carIDCounter;
    }

    // Child classes will calculate their own net weight of a car
    public abstract Integer getNetWeight();

    // Child classes will calculate needed electricity based on other atributes
    public abstract Integer getHowMuchElectricity();

    // determining the need to connect to electricity
    public abstract boolean requiredElectricity();

}
