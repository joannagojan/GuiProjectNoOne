public class Locomotive {

    public final Integer locomotiveID;
    private String locomotiveName;
    private String locomotiveHomeStation;
    private String locomotiveDestinationStation;
    private String locomotiveSource;
    private Integer maxNumberCars;
    private Integer maxLoadWeight;

    private static Integer locomotiveIDCounter = 0;
    private Integer locomotiveSpeed;


    //Construtor of Locomotive class
    public Locomotive(String locomotiveName, String locomotiveHomeStation, String locomotiveDestinationStation,
                      String locomotiveSource, Integer maxNumberCars, Integer maxLoadWeight,
                      Integer locomotiveSpeed) {
        // max weight of the load cannot be smaller than 5000 tons and bigger than 13000 tons
        if (maxLoadWeight < 5000 || maxLoadWeight < 13000) {
            throw new IllegalArgumentException("Maximum load weight must be in range of 5000-13000 tons ");
        }

        this.locomotiveID = ++locomotiveIDCounter; // automatic ID counter with every created object
        this.locomotiveName = locomotiveName;
        this.locomotiveHomeStation = locomotiveHomeStation;
        this.locomotiveDestinationStation = locomotiveDestinationStation;
        this.locomotiveSource = locomotiveSource;
        this.maxNumberCars = maxNumberCars;
        this.maxLoadWeight = maxLoadWeight;
        this.locomotiveSpeed = locomotiveSpeed;

    }
    // getters of Locomotive class

    public Integer getLocomotiveID() {
        return locomotiveID;
    }

    public String getLocomotiveName() {
        return locomotiveName;
    }

    public String getLocomotiveHomeStation() {
        return locomotiveHomeStation;
    }

    public String getLocomotiveDestinationStation() {
        return locomotiveDestinationStation;
    }

    public String getLocomotiveSource() {
        return locomotiveSource;
    }

    public Integer getMaxNumberCars() {
        return maxNumberCars;
    }

    public Integer getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public Integer getLocomotiveSpeed() {
        return locomotiveSpeed;
    }


    //setters of Locomotive class
    public void setLocomotiveName(String locomotiveName) {
        this.locomotiveName = locomotiveName;
    }

    public void setLocomotiveHomeStation(String locomotiveHomeStation) {
        this.locomotiveHomeStation = locomotiveHomeStation;
    }

    public void setLocomotiveDestinationStation(String locomotiveDestinationStation) {
        this.locomotiveDestinationStation = locomotiveDestinationStation;
    }

    public void setLocomotiveSource(String locomotiveSource) {
        this.locomotiveSource = locomotiveSource;
    }

    public void setMaxNumberCars(Integer maxNumberCars) {
        this.maxNumberCars = maxNumberCars;
    }

    public void setMaxLoadWeight(Integer maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }


    // toString for printing information about Locomotive class
    @Override
    public String toString() {
        return "This is locomotive number " + locomotiveID + " called " + locomotiveName + " it departs from " + locomotiveHomeStation
                + "with a destination in " + locomotiveDestinationStation + " it's source is " + locomotiveSource +
                " with maximum number of cars of " + maxNumberCars + " and maximum weight load " + maxLoadWeight + " of the speef of "
                + locomotiveSpeed  + '.';
    }

//    public Integer locoSpeedChange() {
//
//    }
}
