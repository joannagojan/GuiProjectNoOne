package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class GaseousMatCar extends BasicFreightCar {

    private String gasName;
    private Integer gasVolume;

    public GaseousMatCar() {
        gasName = null;
        gasVolume = 0;
    }

    public void addGasToCar(String addedGasName, Integer addedVolume) throws Exception {
        if (gasName == null){
            gasName = addedGasName;
            gasVolume = addedVolume;
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


}
