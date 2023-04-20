package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Liquids;
import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.concurrent.atomic.AtomicInteger;

// One ToxicLiquidMatCar transports one type of Liquid
public class ToxicLiquidMatCar extends LiquidMatCar implements LiquidCharCar {

    private final Integer MAX_CAPACITY = 80000; // maximum capacity of ToxicLiquidMatCar in liters
    private Liquids transportedLiquid;

    public ToxicLiquidMatCar() {
    }

    @Override
    public void addOneLiquidToCar(Liquids liquid) throws Exception {
        if (this.transportedLiquid == null) {
            if (liquid.getSecurityLevel() < 1) {
                throw new Exception("this car only transport toxic liquids with security level above 0");
            } else {
                if(liquid.getVolume() > MAX_CAPACITY){
                    throw new Exception("Liquid's volume is too big for this cars max capacity of: " + MAX_CAPACITY);
                }
                this.transportedLiquid = liquid;
            }

        } else {
            throw new Exception("This car is already transporting other liquid");
        }
    }

    public void removeTransportedLiquid() {
        this.transportedLiquid = null;
    }


    // Risk of spillage based on liquid density and security level
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
    public AtomicInteger getGrossWeight() {
        int totalWeightOfCargo = 0;
        totalWeightOfCargo += transportedLiquid.getLiquidTotalWeight();
        AtomicInteger result = new AtomicInteger();
        result.set(Cars.getStandardNetWeight().get() + totalWeightOfCargo);
        return result;
    }


}
