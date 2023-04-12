package Railway.CarTypes;

public class RestaurantCar extends Cars {
    public RestaurantCar() {
        super();
    }

    @Override
    public Integer getGrossWeight() {
        return null;
    }

    @Override
    public Integer getCarID() {
        return super.getCarID();
    }

    @Override
    public void setCarID(Integer carID) {
        super.setCarID(carID);
    }

    @Override
    public void setCarWidth(Integer carWidth) {
        super.setCarWidth(carWidth);
    }

    @Override
    public void setCarHeight(Integer carHeight) {
        super.setCarHeight(carHeight);
    }

    @Override
    public void setCarLength(Integer carLength) {
        super.setCarLength(carLength);
    }

    @Override
    public void setCarWeight(Integer carWeight) {
        super.setCarWeight(carWeight);
    }

    @Override
    public boolean requiredElectricity() {
        return true;
    }
}
