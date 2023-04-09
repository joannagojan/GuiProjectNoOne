public class HeavyFreightCar extends FreightCar {
    private Integer standardPackageWeight = 200; // weight of one package for heavy Freight is 200kg

    public HeavyFreightCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight) {
        super(securityInformation, netWeight, shipperNumber);
        this.standardPackageWeight = standardPackageWeight;
    }

    @Override
    public Integer getPackageWeight() {
        return standardPackageWeight;
    }
    @Override
    public boolean requiredElectricity() {
        return requiredElectricity();
    }
}
