package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Packages;

import java.util.ArrayList;

public interface CargoCars<T> {
    public ArrayList<T> getAllCargo();
public void addCargo(Packages packages);
}
