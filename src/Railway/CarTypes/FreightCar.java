package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;

import java.util.LinkedList;
import java.util.List;

public abstract class FreightCar extends Cars {
    private List<Cargo> aPackages = new LinkedList<>();


    public Integer getTotalWeightOfPackages() {
        Integer sum = 0;
        for (Cargo p : aPackages) {
            sum += p.getLoadWeight();
        }
        return sum;
    }

}
