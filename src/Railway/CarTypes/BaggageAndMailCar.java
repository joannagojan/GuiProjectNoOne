package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class BaggageAndMailCar extends Cars implements CargoCars<Cargo> {
    private ArrayList<Cargo> allCargo;
    private final Integer MAX_TRANSPORTED_VOLUME = Cars.getCarWidth() * Cars.getCarHeight() * getCarLength();
    private AtomicInteger currentTransportedVolume;
    private static final AtomicInteger baggageCarIDCounter = new AtomicInteger(0);
    private Integer baggageCarID;



    public BaggageAndMailCar() {
        this.allCargo = new ArrayList<>();
        this.currentTransportedVolume = new AtomicInteger(0);
        this.baggageCarID = baggageCarIDCounter.incrementAndGet();

    }


    @Override
    public void addCargo(Cargo cargo) throws Exception {
        int howFreeMuchVolumeLeft = MAX_TRANSPORTED_VOLUME - currentTransportedVolume.get();
        if(allCargo.size() > howFreeMuchVolumeLeft) {
            if (cargo.getPackageType().equals("Small") || cargo.getPackageType().equals("Medium") || cargo.getPackageType().equals("Large") )
            {
                allCargo.add(cargo);
                int packageVolume = cargo.calculatePackageVolume();
                currentTransportedVolume.addAndGet(packageVolume);
                System.out.println("Letter added to mail car! Letter information: " + cargo);}
            else {throw  new Exception("You can only add letters to mail car");}}
    else {throw new Exception("Not enought volume left to add another package, volume left: " + howFreeMuchVolumeLeft);}

    }



    @Override
    public void removeCargo(Cargo cargo) throws Exception {
        if (allCargo.contains(cargo)) {
            allCargo.remove(cargo);
        } else {
            System.out.println("Package you are trying to remove is not transported in this car."
            );

        }}

    @Override
    public AtomicInteger getGrossWeight() {
        int totalWeightOfCargo = 0;
        for (Cargo cargo : allCargo) {
            totalWeightOfCargo += cargo.getLoadWeight();
        }
        AtomicInteger result = new AtomicInteger();
        result.set(Cars.getStandardNetWeight().get() + totalWeightOfCargo);
        return result;
    }


    @Override
    public boolean requiredElectricity () {
        return false;
    }

    public Integer getBaggageCarID() {
        return baggageCarID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This is Baggage Car of ID: ").append(baggageCarID)
                .append(", allCargo names: ");
        sb.append("This cars trainset ID: ").append(getTrainsetID());
        for (Cargo cargo : allCargo) {
            sb.append(cargo.getName()).append(", ");
        }
        sb.append("maximum possible transported weight on this car: ").append(MAX_TRANSPORTED_VOLUME).append(" kgs")
                .append(", currently transported weight: ").append(currentTransportedVolume).append(" kgs.");
        return sb.toString();
    }
}
