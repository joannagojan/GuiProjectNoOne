package CarTypes;

public class GaseousMatCar extends BasicFreightCar {
    private Integer gaseousPackageWeight = 10;
    public GaseousMatCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight);
    }

    @Override
    public Integer getPackageWeight() {
        return gaseousPackageWeight;
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
