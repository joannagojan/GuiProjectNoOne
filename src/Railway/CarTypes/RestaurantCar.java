package Railway.CarTypes;

public class RestaurantCar extends Cars {

    private Integer numberOfMeatMeals;
    private Integer numberOfVegetarianMeals;

    public RestaurantCar(Integer numberOfMeatMeals, Integer numberOfVegetarianMeals) {
        this.numberOfMeatMeals = numberOfMeatMeals;
        this.numberOfVegetarianMeals = numberOfVegetarianMeals;
    }

    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
