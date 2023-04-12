package CarTypes;

public class GaseousMatCar extends BasicFreightCar {

    @Override
    public Integer getGrossWeight() {
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
