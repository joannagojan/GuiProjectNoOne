public class Passenger {

    private Integer passengerID;
    private Integer passengerIDCounter = 0;
    private String passengerName;
    private Integer averageWeightOfPassenger = 80; // average weight of 1 passenger is 80kgs


    public Passenger(String passengerName) {
        this.passengerID = ++passengerIDCounter;
        this.passengerName = passengerName;
    }

}
