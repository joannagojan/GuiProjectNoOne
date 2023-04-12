import java.util.ArrayList;
import java.util.List;

public class BaggageAndMailCar<T extends CustomerLoad> extends Cars {
    private List<T> objects = new ArrayList<>();
    public BaggageAndMailCar(List<Package> packagesInMailCar) {
    }

    public boolean addBagsAndMailCar(List<T> bagsAndMailToAdd) {
    return true ;
    }

    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
