package Railway.CarTypes;

import Railway.Functionalities.CustomerLoad;

import java.util.ArrayList;

public class BaggageAndMailCar<T extends CustomerLoad> extends Cars implements CargoCars<T> {
    private ArrayList<T> allCargo;
    private Integer maxNumberOfPackages;

    public BaggageAndMailCar(Integer maxNumberOfPackages) {
        this.allCargo = new ArrayList<>();
        this.maxNumberOfPackages = maxNumberOfPackages;
    }

    @Override
    public Integer getGrossWeight() {
        Integer totalWeightOfLoad = 0;
        for (T bag : allCargo) {
            totalWeightOfLoad += bag.getLoadWeight();
        }
        return totalWeightOfLoad;
    }

    public ArrayList<T> getAllCargo() {
        return allCargo;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
