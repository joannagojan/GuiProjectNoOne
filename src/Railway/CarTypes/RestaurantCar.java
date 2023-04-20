package Railway.CarTypes;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RestaurantCar extends Cars {

    private static final AtomicInteger restaurantCarIDCounter = new AtomicInteger(0);
    private Integer restaurantCarID;
    private AtomicInteger numberOfMeatMeals; // number of reserved meat meals
    private AtomicInteger numberOfVegetarianMeals; // number of reserved vegetarian meals
    private Integer timeMeatMeal = 40; // in minutes
    private Integer timeVegMeals = 30; // in minutes
    private AtomicInteger timeToPrepareMeals;


    public RestaurantCar(Integer numberOfMeatMeals, Integer numberOfVegetarianMeals) {
        this.numberOfMeatMeals = new AtomicInteger(numberOfMeatMeals);
        this.numberOfVegetarianMeals = new AtomicInteger(numberOfVegetarianMeals);
        this.restaurantCarID = restaurantCarIDCounter.incrementAndGet();
    }

    // based on time needed to prepare the meal calculating total time needed to prepare all meals
    public AtomicInteger getTimeToPrepareMeals() {
        Integer totalTimeVegMeals = timeVegMeals * numberOfVegetarianMeals.intValue();
        Integer totalTimeMeatMeals = timeMeatMeal * numberOfMeatMeals.intValue();
        AtomicInteger totalTime = new AtomicInteger(totalTimeVegMeals + totalTimeMeatMeals);
        return totalTime;
    }


    // passenger can add meals to be prepared in restaurant car
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


// Weight of meals is very small so gross weight is approximately equal to net weight of a car
    @Override
    public AtomicInteger getGrossWeight() {
        return Cars.getStandardNetWeight();
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RestaurantCar ID: ").append(restaurantCarID);
        sb.append("numberOfMeatMeals:").append(numberOfMeatMeals);
        sb.append(", numberOfVegetarianMeals:").append(numberOfVegetarianMeals);
        sb.append(", timeMeatMeal:").append(timeMeatMeal);
        sb.append(", timeVegMeals:").append(timeVegMeals);
        sb.append(", timeToPrepareMeals:").append(timeToPrepareMeals);
        sb.append("}");
        return sb.toString();
    }
}
