package Railway.Functionalities;

import Railway.CustomerLoad;
import Railway.Functionalities.Passenger;

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
