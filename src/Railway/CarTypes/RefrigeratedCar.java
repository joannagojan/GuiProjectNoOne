package Railway.CarTypes;

import Railway.Functionalities.CarRelated.Cargo;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RefrigeratedCar extends BasicFreightCar {

    private AtomicInteger currentTemperature;
    private Integer maxEffectiveTemperature;
    private Integer minEffectiveTemperature;
    private ArrayList<Cargo> cargos;
    private Integer temperatureRaise = 1;
    private static final AtomicInteger refrigeratedCarIDCounter = new AtomicInteger(0);
    private Integer refrigeratedCarID;

    public RefrigeratedCar(Integer maxNumberOfItems) {
        this.maxEffectiveTemperature = 0; // temperature max range in Celsius
        this.minEffectiveTemperature = -15; // min range
        this.currentTemperature = new AtomicInteger(0);
        cargos = new ArrayList<>();
        this.refrigeratedCarID = refrigeratedCarIDCounter.incrementAndGet();
    }


    // Adding an item to refrigerated car raises temperature by 1 degree
    public void addCargo(Cargo cargo) {
        cargos.add(cargo);
        Integer currentTempInts = currentTemperature.intValue() + temperatureRaise;
        currentTemperature.set(currentTempInts);
    }

    // Method to remove a cargo from the refrigerator car
    public void removeCargo(Cargo cargo) throws Exception {
        if (cargos.contains(cargo)) {
            cargos.remove(cargo);
            Integer currentTempInts = currentTemperature.intValue() - temperatureRaise;
            currentTemperature.set(currentTempInts);
        } else {
            throw new Exception("This refrigerated item is not transported on this car");
        }
    }

    // Checking if the current temperature is within the effective temperature range
    public boolean isTemperatureInRange() {
        int temperature = currentTemperature.get();
        return temperature >= minEffectiveTemperature && temperature <= maxEffectiveTemperature;
    }

    // To display a warning if the current temperature is outside the effective temperature range
    public void displayTemperatureWarning() {
        int temperature = currentTemperature.get();
        if (temperature < minEffectiveTemperature || temperature > maxEffectiveTemperature) {
            System.out.println("WARNING: Current temperature is outside the effective temperature range!");
        }
    }


    public AtomicInteger getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(AtomicInteger currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Integer getMaxEffectiveTemperature() {
        return maxEffectiveTemperature;
    }

    public void setMaxEffectiveTemperature(Integer maxEffectiveTemperature) {
        this.maxEffectiveTemperature = maxEffectiveTemperature;
    }

    public Integer getMinEffectiveTemperature() {
        return minEffectiveTemperature;
    }

    public void setMinEffectiveTemperature(Integer minEffectiveTemperature) {
        this.minEffectiveTemperature = minEffectiveTemperature;
    }

    public ArrayList<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(ArrayList<Cargo> cargos) {
        this.cargos = cargos;
    }

    @Override
    public AtomicInteger getGrossWeight() {
        AtomicInteger totalWeightOfLoad = new AtomicInteger(0);
        for (Cargo cargo : cargos) {
            totalWeightOfLoad.addAndGet(cargo.getLoadWeight());
        }
        return totalWeightOfLoad;
    }


    @Override
    public String toString() {
        return "RefrigeratedCar ID: " + refrigeratedCarID +
                ", currentTemperature:" + currentTemperature +
                ", maxEffectiveTemperature:" + maxEffectiveTemperature +
                ", minEffectiveTemperature:" + minEffectiveTemperature +
                ", cargos:" + cargos +
                ", temperatureRaise:" + temperatureRaise ;
    }
    @Override
    public boolean requiredElectricity() {

        return true;
    }


}
