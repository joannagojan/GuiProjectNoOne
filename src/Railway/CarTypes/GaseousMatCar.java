package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class GaseousMatCar extends BasicFreightCar {

    private String gasName;
    private Integer gasVolume;
    private static final AtomicInteger gasCarIDCounter = new AtomicInteger(0);
    private Integer gasCarID;
    private Integer maxVolumeAvailable = 100000; // in liters

    public GaseousMatCar() {
        gasName = null;
        gasVolume = 0;
        gasCarIDCounter.incrementAndGet();
    }

    public void addGasToCar(String addedGasName, Integer addedVolume) throws Exception {
        if (gasName == null){
            gasName = addedGasName;
            if(gasVolume <= 0 && gasVolume > maxVolumeAvailable) {
            gasVolume = addedVolume;}
            else {throw new Exception("The volume of added gas has the be in this range: 0-" + maxVolumeAvailable + " liters");}
        }
        else {throw new Exception("This car is already transporting another gas");}
    }

    public void removeGasFromCar(String removedGas) throws Exception{
        if(gasName != null) {
            gasName = null;
            gasVolume = 0;
        }
        else {throw new Exception("This car is not transporting any gas");}
    }


    // Car transporting gas approximately has the same weight as an empty car
    @Override
    public AtomicInteger getGrossWeight() {
        return Cars.getStandardNetWeight();
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }

    @Override
    public String toString() {
        return "This Gaseous Material Transporting Car IDL " + gasCarID +
                ", name of transported gas is: " + gasName + '\'' +
                " and its volume: " + gasVolume +
                '}';
    }
}
