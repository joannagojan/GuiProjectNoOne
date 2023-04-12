package Railway.CarTypes;

import Railway.Packages;

import java.util.LinkedList;
import java.util.List;


public class PostOfficeCar extends Cars{

    private List<Packages> packages = new LinkedList<>();

//    public void addPackage(Package package) {
//        packages.add(package);
//    }

    public Integer getTotalWeight() {
        int sum = 0;
        for (Packages p : packages) {
            sum += p.getLoadWeight();
        }
        return sum;
    }

    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
