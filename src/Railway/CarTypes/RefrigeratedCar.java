package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class RefrigeratedCar extends BasicFreightCar {


    @Override
    public AtomicInteger getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }


}
