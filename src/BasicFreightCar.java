public class BasicFreightCar extends FreightCar {
    private Integer standardPackageWeight = 100; // weight of one package for basic Freight is 100kg

    public BasicFreightCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight) {
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
