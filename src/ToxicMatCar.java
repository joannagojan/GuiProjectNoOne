public class ToxicMatCar extends HeavyFreightCar{
    private Integer toxicMaterialWeight = 40;
    public ToxicMatCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight);
    }

    @Override
    public Integer getPackageWeight() {
        return toxicMaterialWeight;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
