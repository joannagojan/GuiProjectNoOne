public class Baggage implements CustomerLoad {
    private Integer baggage;
    private Passenger ownerOfBaggage;

    public Baggage(Passenger passenger) {
        this.ownerOfBaggage = passenger;
    }
    @Override
    public Integer getLoadWeight() {
        return ownerOfBaggage.getWeightOfBaggage();
    }
}
