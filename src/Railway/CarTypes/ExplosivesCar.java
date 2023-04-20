package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;
import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ExplosivesCar extends HeavyFreightCar {

    private AtomicInteger currentSecurityLevel;
    private Integer maxAllowedSecurity;
    private ArrayList<TransportedMaterials> transportedExplosives;

    public ExplosivesCar(Integer maxAllowedSecurity) {
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
    public boolean requiredElectricity() {
        return false;
    }
}
