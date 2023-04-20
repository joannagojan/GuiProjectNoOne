package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class BaggageAndMailCar extends Cars implements CargoCars<Cargo> {
    private ArrayList<Cargo> allCargo;
    private final Integer MAX_TRANSPORTED_VOLUME = Cars.getCarWidth() * Cars.getCarHeight() * getCarLength();
    private AtomicInteger currentTransportedVolume;



    public BaggageAndMailCar() {
        this.allCargo = new ArrayList<>();
        this.currentTransportedVolume = new AtomicInteger(0);

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
    public AtomicInteger getGrossWeight () {
        AtomicInteger totalWeightOfLoad = new AtomicInteger(0);
        for (Cargo cargo : allCargo) {
            totalWeightOfLoad.addAndGet(cargo.getLoadWeight());
        }
        return totalWeightOfLoad;
    }


    @Override
    public boolean requiredElectricity () {
        return false;
    }

}
