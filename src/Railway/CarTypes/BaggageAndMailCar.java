package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class BaggageAndMailCar extends Cars implements CargoCars<Cargo> {
    private ArrayList<Cargo> allCargo;
    private Integer maxNumberOfLetters;
    private AtomicInteger currentNumberOfTransportedLetters;

    public BaggageAndMailCar(Integer maxNumberOfLetters) {
        this.allCargo = new ArrayList<>();
        this.maxNumberOfLetters = maxNumberOfLetters;
        this.currentNumberOfTransportedLetters = new AtomicInteger(0);
    }

    @Override
    public void addCargo(Cargo cargo) {
        if(maxNumberOfLetters < allCargo.size()){
            if (cargo.getPackageType().equals("Letter"))
            {
                allCargo.add(cargo);
                currentNumberOfTransportedLetters.incrementAndGet();
                System.out.println("Letter added to mail car! Letter information: " + cargo);}
            else {System.out.println("You can only add letters to mail car");}
        }
        else {System.out.println("This letter will not fit into Mail Car. This car's max number of transported letters: " + maxNumberOfLetters);}
    }
@Override
    public void removeCargo(Cargo cargo) {
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
