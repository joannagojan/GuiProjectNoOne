package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Liquids;

public interface LiquidCharCar {

    String riskOfSpillage(); // Liquid car and Toxic liquid car will calculate their own risk of spillage
    void addOneLiquidToCar(Liquids liquid)  throws Exception ;  // Method that will add liquid to car if possible
    void removeTransportedLiquid();
}
