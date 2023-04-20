package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Liquids;
import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.concurrent.atomic.AtomicInteger;

// One ToxicLiquidMatCar transports one type of Liquid
public class ToxicLiquidMatCar extends LiquidMatCar implements LiquidCharCar {

    private final Integer MAX_CAPACITY = 80000; // maximum capacity of ToxicLiquidMatCar in liters
    private Liquids transportedLiquid;
    private static final AtomicInteger toxicLiquidCarIDCounter = new AtomicInteger(0);
    private Integer toxicLiquidCarID;


    public ToxicLiquidMatCar() {
        this.toxicLiquidCarID = toxicLiquidCarIDCounter.incrementAndGet();
    }

    // adding only toxic liquids to this car and checking if liquids volume will fit this car
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

    // removing liquid from a car

    public void removeTransportedLiquid() {
        transportedLiquid = null;
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

    // gross weight based on given weight of a liquid
    @Override
    public AtomicInteger getGrossWeight() {
        int totalWeightOfCargo = 0;
        totalWeightOfCargo += transportedLiquid.getLiquidTotalWeight();
        AtomicInteger result = new AtomicInteger();
        result.set(Cars.getStandardNetWeight().get() + totalWeightOfCargo);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToxicLiquidMatCar ID: ").append(toxicLiquidCarID).append("\n");
        sb.append("Transported Liquid: ");
        if (transportedLiquid == null) {
            sb.append("None");
        } else {
            sb.append(transportedLiquid.getName()).append("\n");
            sb.append("Liquid Security Level: ").append(transportedLiquid.getSecurityLevel()).append("\n");
            sb.append("Risk of Spillage: ").append(riskOfSpillage()).append("\n");
            sb.append("Gross Weight: ").append(getGrossWeight()).append("\n");
        }
        return sb.toString();
    }


    public Integer getSecurityOfLiquid(){
        return transportedLiquid.getSecurityLevel();
    }
    public Liquids getTransportedLiquid() {
        return transportedLiquid;
    }
}

