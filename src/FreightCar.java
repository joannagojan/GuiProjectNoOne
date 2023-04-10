public abstract class FreightCar extends Cars {


    public FreightCar(String securityInformation, Integer netWeight) {
        super(securityInformation, netWeight);
    }

    public abstract Integer getPackageWeight();

    public abstract Integer getShipperNumber(); //how many packages are being transported

    public Integer getTotalWeightOfPackages() {
        return getPackageWeight() * getShipperNumber();
    }
}
