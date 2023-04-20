package Railway.CarTypes;

import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantCar extends Cars {

    private Integer numberOfMeatMeals;
    private Integer numberOfVegetarianMeals;

    public RestaurantCar(Integer numberOfMeatMeals, Integer numberOfVegetarianMeals) {
        this.numberOfMeatMeals = numberOfMeatMeals;
        this.numberOfVegetarianMeals = numberOfVegetarianMeals;
    }

    @Override
    public AtomicInteger getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
