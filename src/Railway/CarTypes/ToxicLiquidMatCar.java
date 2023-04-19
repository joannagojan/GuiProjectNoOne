package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Liquids;

// One ToxicLiquidMatCar transports one type of Liquid
public class ToxicLiquidMatCar extends LiquidMatCar implements LiquidCharCar {

    private Integer maxCapacityLiters = 80000;
    private Liquids transportedLiquid;

    public ToxicLiquidMatCar() {
    }

    @Override
    public void addOneLiquidToCar(Liquids liquid) throws Exception {
        if (this.transportedLiquid == null) {
            if (liquid.getSecurityLevel() < 1) {
                throw new Exception("this car only transport toxic liquids with security level above 0");
            } else {
                this.transportedLiquid = liquid;
            }

        } else {
            throw new Exception("This car is already transporting other liquid");
        }
    }

    public void removeTransportedLiquid() {
        this.transportedLiquid = null;
    }


    // Risk of spilage based on liquid density and security level
    @Override
    public String riskOfSpillage() {
        if (transportedLiquid.getLiquidDensity() < 500) {
            if (transportedLiquid.getSecurityLevel().equals(1)) {
                return "Medium risk";
            } else {
                return "High risk";
            }
        } else {
            return "Low risk";
        }
    }

    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return super.requiredElectricity();
    }

    @Override
    public Integer getTotalWeightOfPackages() {
        return super.getTotalWeightOfPackages();
    }


}
