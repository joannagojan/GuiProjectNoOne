package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Trainset {
    private Locomotive trainsetLocomotive;
    private ArrayList<Cars> cars;
    private static final AtomicInteger trainsetIDCounter = new AtomicInteger(0);
    private final Integer trainsetID;

    public Trainset(Locomotive trainsetLocomotive) {
        this.trainsetID = trainsetIDCounter.incrementAndGet();
        this.trainsetLocomotive = trainsetLocomotive;
        ArrayList<Cars> cars = new ArrayList<>();
    }

    public void addCar(Cars railRoadCar) throws Exception {
        if (trainsetLocomotive.getMaxNumberCars() < cars.size()) {
            cars.add(railRoadCar);
        } else
            throw new Exception("Too many cars, this locomotives car limit is: " + trainsetLocomotive.getMaxNumberCars());
        if(trainsetLocomotive.getMaxElectricCarsConnected())
    }
}

