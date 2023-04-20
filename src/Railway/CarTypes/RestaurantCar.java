package Railway.CarTypes;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantCar extends Cars {

    private AtomicInteger numberOfMeatMeals; // number of reserved meat meals
    private AtomicInteger numberOfVegetarianMeals; // number of reserved vegetarian meals
    private Integer timeMeatMeal = 40; // in minutes
    private Integer timeVegMeals = 30; // in minutes
    private AtomicInteger timeToPrepareMeals;

    public RestaurantCar(AtomicInteger numberOfMeatMeals, AtomicInteger numberOfVegetarianMeals) {
        this.numberOfMeatMeals = numberOfMeatMeals;
        this.numberOfVegetarianMeals = numberOfVegetarianMeals;
    }

    public AtomicInteger getTimeToPrepareMeals() {
        Integer totalTimeVegMeals = timeVegMeals * numberOfVegetarianMeals.intValue();
        Integer totalTimeMeatMeals = timeMeatMeal * numberOfMeatMeals.intValue();
        AtomicInteger totalTime = new AtomicInteger(totalTimeVegMeals + totalTimeMeatMeals);
        return totalTime;
    }

    public void reserveMeal(String vegOrMeat) throws Exception {

        if (vegOrMeat.equals("vegetarian")) {
            numberOfVegetarianMeals.incrementAndGet();
        }
        if (vegOrMeat.equals("meat"))
        {
            numberOfMeatMeals.incrementAndGet();
        }
        else{throw new Exception("This meal type not available on this train");}

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
