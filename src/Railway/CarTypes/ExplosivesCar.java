package Railway.CarTypes;

public class ExplosivesCar extends HeavyFreightCar {
    private Integer explosiveWeight = 100;


    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
