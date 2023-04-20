package Railway.CarTypes;

import Railway.Functionalities.CarRelated.TransportedMaterials;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ToxicMatCar extends HeavyFreightCar {
    private ArrayList<String> notAllowedToxicMaterials;
    private ArrayList<TransportedMaterials> allTransportedToxicMat;
    private static final AtomicInteger toxicCarIDCounter = new AtomicInteger(0);
    private Integer toxicCarID;

    public ToxicMatCar(Integer maxAllowedSecurity) {
        this.allTransportedToxicMat = new ArrayList<>();
        this.notAllowedToxicMaterials = new ArrayList<>();
        this.toxicCarID = toxicCarIDCounter.incrementAndGet();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ToxicMatCar ID: ").append(toxicCarID).append("\n");
        sb.append("Transported Toxic Materials: ");
        if (allTransportedToxicMat.isEmpty()) {
            sb.append("None");
        } else {
            for (TransportedMaterials toxicMat : allTransportedToxicMat) {
                sb.append(toxicMat.getName()).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("\n");
        sb.append("Gross Weight: ").append(getGrossWeight()).append("\n");
        sb.append("Required Electricity: ").append(requiredElectricity()).append("\n");
        return sb.toString();
    }


}
