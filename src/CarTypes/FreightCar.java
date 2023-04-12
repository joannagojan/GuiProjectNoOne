package CarTypes;

import java.util.LinkedList;
import java.util.List;

public abstract class FreightCar extends Cars {
    private List<Package> packages = new LinkedList<>();


    public Integer getTotalWeightOfPackages() {
        Integer sum = 0;
        for (Package p : packages) {
            sum += p.get;
        }
        return sum;
    }

}
