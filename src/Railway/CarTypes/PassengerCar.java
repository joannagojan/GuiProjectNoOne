package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Passenger;
import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PassengerCar extends Cars {
    private Integer numberOfSeats; // how many seats are available
    private Integer currentNumberOfPassengers;
    private ArrayList<Passenger> allPassengers;


    //Constructor

    public PassengerCar(Integer numberOfSeats) {
        //ranges to pick from
        if (numberOfSeats > 100 || numberOfSeats < 10) {
            throw new IllegalArgumentException("Pick a number of seats from a range 10-100, you picked: "+ numberOfSeats);
        }
        else {this.numberOfSeats = numberOfSeats;}
this.allPassengers = new ArrayList<>();
        this.currentNumberOfPassengers = 0;
    }

public void addPassengerToCar(Passenger passenger) throws Exception {
        if (++currentNumberOfPassengers <= numberOfSeats ) {
            allPassengers.add(passenger);
        }
        else {throw new Exception("All seats are already taken in this car");}
}

public void removePassenger(Passenger passenger) throws Exception{
        if (allPassengers.contains(passenger)){
            allPassengers.remove(passenger);
        }
        else {throw new Exception("Passenger you are trying to remove is not in this car");}
}
    @Override
    public AtomicInteger getGrossWeight() {
        int weighOfAllPassengers = 0;
        for (Passenger passenger : allPassengers) {
            weighOfAllPassengers += passenger.getAverageWeightOfPassenger();
        }
        AtomicInteger result = new AtomicInteger();
        result.set(Cars.getStandardNetWeight().get() + weighOfAllPassengers);
        return result;
    }


    @Override
    public boolean requiredElectricity() {
        return true;
    }
}

