public class Passenger {

    private Integer passengerID;
    private Integer passengerIDCounter = 0;
    private String passengerName;
    private Integer averageWeightOfPassenger = 80; // average weight of 1 passenger is 80kgs
    private Integer weightOfBaggage;


    public Passenger(String passengerName, Integer weightOfBaggage) {
        this.passengerID = ++passengerIDCounter;
        this.passengerName = passengerName;
        this.weightOfBaggage = weightOfBaggage;
    }

    public Integer getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Integer passengerID) {
        this.passengerID = passengerID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getAverageWeightOfPassenger() {
        return averageWeightOfPassenger;
    }

    public void setAverageWeightOfPassenger(Integer averageWeightOfPassenger) {
        this.averageWeightOfPassenger = averageWeightOfPassenger;
    }

    public Integer getWeightOfBaggage() {
        return weightOfBaggage;
    }

    public void setWeightOfBaggage(Integer weightOfBaggage) {
        this.weightOfBaggage = weightOfBaggage;
    }
}
