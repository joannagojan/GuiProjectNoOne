package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;

import java.util.LinkedList;
import java.util.List;


public class PostOfficeCar extends Cars {

    private List<Cargo> aPackages = new LinkedList<>();

//    public void addPackage(Package package) {
//        packages.add(package);
//    }

    public Integer getTotalWeight() {
        int sum = 0;
        for (Cargo p : aPackages) {
            sum += p.getLoadWeight();
        }
        return sum;
    }

    @Override
    public Integer getGrossWeight() {
        return Cars.getStandardNetWeight() + getTotalWeight();
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
