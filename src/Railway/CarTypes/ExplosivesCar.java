package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;
import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ExplosivesCar extends HeavyFreightCar {

    private AtomicInteger currentSecurityLevel;
    private Integer maxAllowedSecurity;
    private ArrayList<TransportedMaterials> transportedExplosives;
    private static final AtomicInteger explosivesCarIDCounter = new AtomicInteger(0);
    private Integer explosivesCarID;

    public ExplosivesCar(Integer maxAllowedSecurity) {
        this.explosivesCarID = explosivesCarIDCounter.incrementAndGet();
        this.currentSecurityLevel = new AtomicInteger(0);
        this.maxAllowedSecurity = maxAllowedSecurity;
        this.transportedExplosives = new ArrayList<>();
    }

    @Override
    public void addCargo(TransportedMaterials explosive) throws Exception {
        int packageSecurity = explosive.getSecurityLevel();
        int newSecurityLevel = currentSecurityLevel.get() + packageSecurity;

        // With every package the level of security rises exponentially
        double growthFactor = 1.5;
        if (newSecurityLevel * growthFactor < maxAllowedSecurity) {
            transportedExplosives.add(explosive);
        }
        else {throw new Exception("Security level too high to add another explosive. Current security level: " + currentSecurityLevel.intValue());}
        currentSecurityLevel.set(newSecurityLevel);
    }

    @Override
    public void removeCargo(TransportedMaterials explosive) throws Exception {
        if (transportedExplosives.contains(explosive)) {
            transportedExplosives.remove(explosive);
        } else {
            System.out.println("Package you are trying to remove is not transported in this car."
            );
        }}


    @Override
    public AtomicInteger getGrossWeight() {
        int totalWeightOfCargo = 0;
        for (TransportedMaterials  explosive : transportedExplosives) {
            totalWeightOfCargo += explosive.getWeight();
        }
        AtomicInteger result = new AtomicInteger();
        result.set(Cars.getStandardNetWeight().get() + totalWeightOfCargo);
        return result;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExplosivesCar of ID: ").append(explosivesCarID);
        sb.append("currentSecurityLevel: ").append(currentSecurityLevel.get());
        sb.append(", maxAllowedSecurity: ").append(maxAllowedSecurity);
        sb.append(", transportedExplosives: ").append(transportedExplosives);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
