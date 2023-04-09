public class RestaurantCar extends Cars {
    public RestaurantCar(String securityInformation, Integer netWeight) {
        super(securityInformation, netWeight);
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
