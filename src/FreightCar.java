public abstract class FreightCar extends Cars {
    private Integer shipperNumber; // same as load, how many packeges are being transported

    public FreightCar(String securityInformation, Integer netWeight, Integer shipperNumber) {
        super(securityInformation, netWeight);
        this.shipperNumber = shipperNumber;
    }

    public abstract Integer getPackageWeight();

    public Integer getTotalWeightOfPackages() {
        return getPackageWeight() * shipperNumber;
    }
}
