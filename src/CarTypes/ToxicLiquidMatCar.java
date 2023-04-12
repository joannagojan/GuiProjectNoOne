package CarTypes;

public class ToxicLiquidMatCar extends LiquidMatCar {
    public ToxicLiquidMatCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight);
    }

    @Override
    public Integer getPackageWeight() {
        return super.getPackageWeight();
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
