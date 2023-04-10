public abstract class FreightCar extends Cars {

    public abstract Integer getPackageWeight(); //child classes calculate their own package weight

    public abstract Integer getShipperNumber(); //how many packages are being transported

    public Integer getTotalWeightOfPackages() {
        return getPackageWeight() * getShipperNumber();
    }

   public abstract Integer getSecurityAlertLevel(); // child classes calculate the
}
