package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Trainset {
    private Locomotive locomotive;
    private ArrayList<Cars> cars;
    private static final AtomicInteger trainsetIDCounter = new AtomicInteger(0);
    private final Integer trainsetID;

    public Trainset(Locomotive locomotive) {
        this.trainsetID = trainsetIDCounter.incrementAndGet();
        this.locomotive = locomotive;
        ArrayList<Cars> cars = new ArrayList<>();
    }

    public void addCar(){
if (locomotive.getMaxNumberCars()<cars.size())
    }

}