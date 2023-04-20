package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class GaseousMatCar extends BasicFreightCar {

    @Override
    public AtomicInteger getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }

    @Override
    public Integer getTotalWeightOfPackages() {
        return super.getTotalWeightOfPackages();
    }
}
