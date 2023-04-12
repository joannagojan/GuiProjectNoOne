//import java.util.ArrayList;
//import java.util.List;
//
//public class BaggageAndMailCar<T> extends Cars {
//    private List<T> bagsAndMailInCar = new ArrayList<>();
//
//
//    public <T> boolean addBagsAndMailCar(List<T> bagsAndMailToAdd) {
//        Integer maxLoadWeight = Cars.getStandardMaxCarLoad();
//        Integer currentWeight = 0;
//        for (T bag : bagsAndMailToAdd) {
//            if (currentWeight + bag.getLoadWeight() <= maxLoadWeight) {
//                bagsAndMailInCar.add(bag);
//            }
//            else {return false;}
//        }
//        return true;
//    }
//
//    @Override
//    public Integer getGrossWeight() {
//        Integer totalWeightOfLoad = 0;
//        for (T bag : bagsAndMailInCar) {
//            totalWeightOfLoad += bag.getLoadWeight();
//        }
//        return totalWeightOfLoad;
//    }
//
//    @Override
//    public boolean requiredElectricity() {
//        return false;
//    }
//}
