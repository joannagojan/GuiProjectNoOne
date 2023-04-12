package Railway.CarTypes;

public class ExplosivesCar extends HeavyFreightCar {


    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
