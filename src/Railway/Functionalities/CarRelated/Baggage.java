package Railway.Functionalities.CarRelated;

public class Baggage implements Cargo {
    private Passenger ownerOfBaggage;

    public Baggage(Passenger passenger) {
        this.ownerOfBaggage = passenger;
    }

    @Override
    public Integer getLoadWeight() {
        return ownerOfBaggage.getWeightOfBaggage();
    }
}
