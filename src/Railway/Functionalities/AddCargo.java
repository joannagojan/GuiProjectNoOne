package Railway.Functionalities;

import Railway.CarTypes.Cars;
import Railway.CustomerLoad;

import java.util.ArrayList;
import java.util.List;

public class AddCargo<T extends CustomerLoad, C> {

    public boolean addBagsAndMailCar(List<T> bagsAndMailToAdd, C cargoCar) {
        Integer maxLoadWeight = Cars.getStandardMaxCarLoad();
        Integer currentWeight = 0;
        ArrayList<T> allCargo = null;
        for (T bag : bagsAndMailToAdd) {
            if (currentWeight + bag.getLoadWeight() <= maxLoadWeight) {
                allCargo.add(bag);
            }
            else {return false;}
        }
        return true;
    }

}
