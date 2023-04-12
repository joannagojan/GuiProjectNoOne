package CarTypes;

public class ToxicLiquidMatCar extends LiquidMatCar {

    public ToxicLiquidMatCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight, String liquidType) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight, liquidType);
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
