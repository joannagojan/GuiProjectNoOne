package Railway.CarTypes;

public class ToxicLiquidMatCar extends LiquidMatCar {


    public ToxicLiquidMatCar(String liquidType) {
        super(liquidType);
    }

    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return super.requiredElectricity();
    }

    @Override
    public Integer getTotalWeightOfPackages() {
        return super.getTotalWeightOfPackages();
    }
}
