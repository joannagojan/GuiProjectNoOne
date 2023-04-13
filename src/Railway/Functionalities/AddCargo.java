package Railway.Functionalities;

import Railway.CarTypes.CargoCars;
import Railway.CarTypes.Cars;

import java.util.ArrayList;
import java.util.List;

public class AddCargo<T extends CustomerLoad> {

    public boolean addBagsAndMailCar(List<T> bagsAndMailToAdd, CargoCars cargoCars) {
        Integer maxLoadWeight = Cars.getStandardMaxCarLoad();
        Integer currentWeight = 0;
        ArrayList allCargo = cargoCars.getAllCargo();
        for (T bag : bagsAndMailToAdd) {
            if (currentWeight + bag.getLoadWeight() <= maxLoadWeight) {
                allCargo.add(bag);
            } else {
                return false;
            }
        }
        return true;
    }

}