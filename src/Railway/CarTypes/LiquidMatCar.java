package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Liquids;

public abstract class LiquidMatCar extends BasicFreightCar implements LiquidCharCar {

    private Integer maxCapacityLiters = 100000;
    private Liquids transportedLiquid;
    public LiquidMatCar() {
    }


    @Override
    public void addOneLiquidToCar(Liquids liquid) throws Exception {
        if (this.transportedLiquid == null) {
            if (liquid.getSecurityLevel().equals(0)) {
                throw new Exception("this car only transport non toxic liquids with security level 0");
            } else {
                this.transportedLiquid = liquid;
            }

        } else {
            throw new Exception("This car is already transporting other liquid");
        }
    }

    // Risk of spillage based on liquid density. Less dense liquids are more likely to spill (density in kg/m^3)
    public String riskOfSpillage() {
        if (transportedLiquid.getLiquidDensity() < 500) {
            return "Medium risk";}
        else {return "Low risk";}}

    @Override
    public boolean requiredElectricity() {
        return false;
    }

}
