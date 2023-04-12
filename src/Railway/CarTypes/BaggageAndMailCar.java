package Railway.CarTypes;
import Railway.CarTypes.Cars;
import Railway.CustomerLoad;
import java.util.ArrayList;
import java.util.List;

public class BaggageAndMailCar<T extends CustomerLoad> extends Cars {
    ArrayList<T> allCargo;
    Integer maxNumberOfPackages;

    public BaggageAndMailCar(Integer maxNumberOfPackages) {
        this.allCargo = new ArrayList<>();
        this.maxNumberOfPackages = maxNumberOfPackages;
    }

    @Override
    public Integer getGrossWeight() {
        Integer totalWeightOfLoad = 0;
        for (T bag : allCargo) {
            totalWeightOfLoad += bag.getLoadWeight();
        }
        return totalWeightOfLoad;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
