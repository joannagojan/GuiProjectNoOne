package Railway.Functionalities;

public class Baggage implements CustomerLoad {
    private Passenger ownerOfBaggage;

    public Baggage(Passenger passenger) {
        this.ownerOfBaggage = passenger;
    }

    @Override
    public Integer getLoadWeight() {
        return ownerOfBaggage.getWeightOfBaggage();
    }
}
