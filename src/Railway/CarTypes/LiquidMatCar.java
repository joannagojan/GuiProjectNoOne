package Railway.CarTypes;

public abstract class LiquidMatCar extends BasicFreightCar {

    @Override
    public boolean requiredElectricity() {
        return false;
    }

}
