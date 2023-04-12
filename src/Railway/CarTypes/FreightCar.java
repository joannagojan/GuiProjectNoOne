package Railway.CarTypes;

import Railway.Functionalities.Packages;

import java.util.LinkedList;
import java.util.List;

public abstract class FreightCar extends Cars {
    private List<Packages> packages = new LinkedList<>();


    public Integer getTotalWeightOfPackages() {
        Integer sum = 0;
        for (Packages p : packages) {
            sum += p.getLoadWeight();
        }
        return sum;
    }

}
