public class BaggageAndMailCar extends Cars {
    public BaggageAndMailCar(String securityInformation, Integer netWeight) {
        super(securityInformation, netWeight);
    }

    @Override
    public boolean requiredElectricity() {
        return false;
    }
}
