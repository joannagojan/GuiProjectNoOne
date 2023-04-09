public class PostOfficeCar extends Cars{
    public PostOfficeCar(String securityInformation, Integer netWeight) {
        super(securityInformation, netWeight);
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
