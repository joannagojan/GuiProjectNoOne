package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Packages;

import java.util.ArrayList;

public class BaggageAndMailCar extends Cars implements CargoCars {
    private ArrayList<Packages> allCargo;
    private Integer maxNumberOfPackages;

    public BaggageAndMailCar(Integer maxNumberOfPackages) {
        this.allCargo = new ArrayList<>();
        this.maxNumberOfPackages = maxNumberOfPackages;
    }


    @Override
    public Integer getGrossWeight() {
        Integer totalWeightOfLoad = 0;
        for (Packages bag : allCargo) {
            totalWeightOfLoad += bag.getLoadWeight();
        }
        return totalWeightOfLoad;
    }


    @Override
    public boolean requiredElectricity() {
        return false;
    }

    @Override
    public ArrayList getAllCargo() {
        return null;
    }

    @Override
    public void addCargo(Packages packages) {

    }
}
