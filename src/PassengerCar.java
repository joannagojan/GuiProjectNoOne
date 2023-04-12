public class PassengerCar extends Cars {
    private Integer numberOfSeats; // how many seats are available
    private Integer currentNumberOfPassengers;

    //Constructor

    public PassengerCar(Integer numberOfSeats) {
        //ranges to pick from
        if (numberOfSeats > 100 || numberOfSeats < 10) {
            throw new IllegalArgumentException("Pick a number of seats from a range 10-100, you picked: "+ numberOfSeats);
        }
        else {this.numberOfSeats = numberOfSeats;}

        this.currentNumberOfPassengers = 0;
    }


    @Override
    public Integer getGrossWeight() {
        return Cars.getStandardNetWeight() * currentNumberOfPassengers;
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}

