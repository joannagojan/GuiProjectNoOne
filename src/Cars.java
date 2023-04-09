public abstract class Cars {
    private String securityInformation;
    private Integer netWeight;
    private Integer numberOfSeats;
    private Integer carID;
    private static Integer carIDCounter = 0;
    private static Integer howMuchElectricity = 50; // on average on connected car needs 50 kilowatts of electricity

    public Cars(String securityInformation, Integer netWeight) {
        this.securityInformation = securityInformation;
        this.netWeight = netWeight;
        this.carID = ++carIDCounter;
    }


    public abstract boolean requiredElectricity(); // determining the need to connect to electricity

}
