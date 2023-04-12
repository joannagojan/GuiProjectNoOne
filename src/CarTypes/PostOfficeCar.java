package CarTypes;

import java.util.LinkedList;
import java.util.List;

public class PostOfficeCar extends Cars{

    private List<Package> packages = new LinkedList<>();

//    public void addPackage(Package package) {
//        packages.add(package);
//    }

    public Integer getTotalWeight() {
        int sum = 0;
        for (Package p : packages) {
            sum += p.get;
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
