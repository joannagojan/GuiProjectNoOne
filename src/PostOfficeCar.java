import java.util.LinkedList;
import java.util.List;

public class PostOfficeCar extends Cars{

    public PostOfficeCar() {
    }
    private List<Package> packages = new LinkedList<>();

    public void addPackage(Package package) {
        packages.add(package);
    }

    public Integer getTotalWeight() {
        int sum = 0;
        for (Package p : packages) {
            sum += p.getWeight();
        }
        return sum;
    }
}




    @Override
    public Integer getNetWeight() {
        return null;
    }

    @Override
    public Integer getHowMuchElectricity() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
