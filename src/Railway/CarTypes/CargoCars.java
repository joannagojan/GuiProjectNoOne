package Railway.CarTypes;

import Railway.Functionalities.CarRelated.AllTypesTransported;
import Railway.Functionalities.CarRelated.Cargo;

import java.util.ArrayList;

public interface CargoCars<T extends AllTypesTransported>{

    public void addCargo(T cargo) throws Exception;
    public void removeCargo(T cargo) throws Exception;
}