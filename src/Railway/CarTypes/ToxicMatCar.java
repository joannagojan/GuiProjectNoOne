package Railway.CarTypes;

import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ToxicMatCar extends HeavyFreightCar {
    private ArrayList<String> notAllowedToxicMaterials;
    private ArrayList<TransportedMaterials> allTransportedToxicMat;

    public ToxicMatCar(Integer maxAllowedSecurity) {
        this.allTransportedToxicMat = new ArrayList<>();
        this.notAllowedToxicMaterials = new ArrayList<>();
        notAllowedToxicMaterials.add("Nuclear");
    }

    @Override
    public void addCargo(TransportedMaterials toxicMaterial) throws Exception {
        if (notAllowedToxicMaterials.contains(toxicMaterial.getName())) {
            throw new Exception("This type of toxic material is not allowed on this Car");
        }
        else {allTransportedToxicMat.add(toxicMaterial);}
    }

    @Override
    public void removeCargo(TransportedMaterials toxicMaterial) throws Exception {
        if (allTransportedToxicMat.contains(toxicMaterial)) {
            allTransportedToxicMat.remove(toxicMaterial);
        } else {
            System.out.println("Toxic material you are trying is not transported on this car"
            );
        }}

    @Override
    public AtomicInteger getGrossWeight() {
        int totalWeightOfCargo = 0;
        for (TransportedMaterials  toxicMat : allTransportedToxicMat) {
            totalWeightOfCargo += toxicMat.getWeight();
        }
        AtomicInteger result = new AtomicInteger();
        result.set(Cars.getStandardNetWeight().get() + totalWeightOfCargo);
        return result;
    }


    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
