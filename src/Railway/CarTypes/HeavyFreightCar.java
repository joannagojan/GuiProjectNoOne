package Railway.CarTypes;

import Railway.Functionalities.CarRelated.TransportedMaterials;

public abstract class HeavyFreightCar extends FreightCar {

    private static Integer carHeight = 350; // Heavy Freight Car height in cm
    private static Integer carLength = 2000; // Heavy Freight Car width in cm
    private static Integer standardMaxCarLoad = 200; // Heavy Freight Car maximum load in tons


    @Override
    public void addCargo(TransportedMaterials cargo) throws Exception {

    }

    @Override
    public void removeCargo(TransportedMaterials cargo) throws Exception {

    }

    @Override
    public boolean requiredElectricity() {
        return requiredElectricity();
    }
}
