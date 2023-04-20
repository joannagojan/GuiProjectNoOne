package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class ExplosivesCar extends HeavyFreightCar {


    @Override
    public AtomicInteger getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
