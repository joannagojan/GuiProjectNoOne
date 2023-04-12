package CarTypes;

public class ToxicMatCar extends HeavyFreightCar {


    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
