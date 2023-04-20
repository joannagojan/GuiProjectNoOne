package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;

import java.util.ArrayList;

public class BaggageAndMailCar extends Cars {
    private ArrayList<Cargo> allCargo;
    private Integer maxNumberOfPackages;

    public BaggageAndMailCar(Integer maxNumberOfPackages) {
        this.allCargo = new ArrayList<>();
        this.maxNumberOfPackages = maxNumberOfPackages;
    }

    public void addCargo(Cargo cargo) {
        if(maxNumberOfPackages < allCargo.size()){
        allCargo.add(cargo);
        System.out.println("Package added! Package information: " + cargo);}
        else {System.out.println("This package will not fit in this car. This car's max capacity: " + maxNumberOfPackages);}
    }

    public void removeCargo(Cargo cargo) {
        if (allCargo.contains(cargo)) {
            allCargo.remove(cargo);
        } else {
            System.out.println("Package you are trying to remove is not transported in this car."
            );

        }}

        @Override
        public Integer getGrossWeight () {
            Integer totalWeightOfLoad = 0;
            for (Cargo cargo : allCargo) {
                totalWeightOfLoad += cargo.getLoadWeight();
            }
            return totalWeightOfLoad;
        }


        @Override
        public boolean requiredElectricity () {
            return false;
        }

    }
