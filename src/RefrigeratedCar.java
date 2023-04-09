public class RefrigeratedCar extends BasicFreightCar{
    public RefrigeratedCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight);
    }

    @Override
    public Integer getPackageWeight() {
        return super.getPackageWeight();
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }

    @Override
    public Integer getTotalWeightOfPackages() {
        return super.getTotalWeightOfPackages();
    }
}
