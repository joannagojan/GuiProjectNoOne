package Railway.CarTypes;

import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.concurrent.atomic.AtomicInteger;

public class ToxicMatCar extends HeavyFreightCar {


    @Override
    public AtomicInteger getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
