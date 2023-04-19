package Railway.Functionalities.CarRelated;

import java.util.concurrent.atomic.AtomicInteger;

public class Passenger {

    private static final AtomicInteger passengerIDCounter = new AtomicInteger(0);
    private final Integer passengerID;
    private String passengerName;
    private Integer averageWeightOfPassenger = 80; // average weight of 1 passenger is 80kgs
    private Integer weightOfBaggage;


    public Passenger(String passengerName, Integer weightOfBaggage) {
        this.passengerID = passengerIDCounter.incrementAndGet();
        this.passengerName = passengerName;
        this.weightOfBaggage = weightOfBaggage;
    }

    public Integer getPassengerID() {
        return passengerID;
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
