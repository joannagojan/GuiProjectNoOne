public class PassengerCar extends Cars {
    private Integer numberOfSeats; // how many seats are available
    private Integer currentNumberOfPassengers;  // how many seats are filled with passengers
    private Integer grossWeight; // total weight of the car
    private Integer averageWeightOfPassenger = 80; // average weight of 1 passenger is 80kgs

    //Constructor

    public PassengerCar(String securityInformation, Integer netWeight,
                        Integer numberOfSeats, Integer numberOfSeats1,
                        Integer currentNumberOfPassengers) {
        super(securityInformation, netWeight);
        this.numberOfSeats = numberOfSeats1;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
        this.grossWeight = netWeight + averageWeightOfPassenger*currentNumberOfPassengers;

        //ranges to pick from
        if (numberOfSeats > 100 || numberOfSeats < 10) {
            throw new IllegalArgumentException("Pick a number of seats from a range 10-100, you picked: "+ numberOfSeats);
        }
        if (currentNumberOfPassengers > numberOfSeats || currentNumberOfPassengers < 0) {
            throw new IllegalArgumentException("Number of passengers must be smaller than number of seats available" );
        }
    }
    @Override
    public String toString() {return "grossWeight" + grossWeight;}
    @Override
    public boolean requiredElectricity() {
        return true;
    }
}

