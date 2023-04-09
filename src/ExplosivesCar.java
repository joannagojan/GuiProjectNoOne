public class ExplosivesCar extends HeavyFreightCar{
    private Integer explosiveWeight = 100;
    public ExplosivesCar(String securityInformation, Integer netWeight, Integer shipperNumber, Integer standardPackageWeight) {
        super(securityInformation, netWeight, shipperNumber, standardPackageWeight);
    }

    @Override
    public Integer getPackageWeight() {
        return explosiveWeight;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
