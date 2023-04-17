package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Trainset {
    private Locomotive trainsetLocomotive;
    private ArrayList<Cars> trainsetCars;
    private static final AtomicInteger trainsetIDCounter = new AtomicInteger(0);
    private final Integer trainsetID;
    private Integer howCarConnectedElectricity;
    private Integer currentLoadOfTrainset;

    public Trainset(Locomotive trainsetLocomotive) {
        this.trainsetID = trainsetIDCounter.incrementAndGet();
        this.trainsetLocomotive = trainsetLocomotive;
        ArrayList<Cars> trainsetCars = new ArrayList<>(trainsetLocomotive.getMaxNumberCars());
        this.howCarConnectedElectricity = 0;
        this.currentLoadOfTrainset = 0;

    }

    public void addCar(Cars railRoadCar) throws Exception {

        if (trainsetLocomotive.getMaxNumberCars() > trainsetCars.size()) {
throw new Exception("Too many cars, this locomotives car limit is: " + trainsetLocomotive.getMaxNumberCars());}
        if (railRoadCar.requiredElectricity()) {
            if (howCarConnectedElectricity <= trainsetLocomotive.getMaxElectricCarsConnected())
                howCarConnectedElectricity++;
        } else throw new Exception("Too many cars connected to electricity grid");
        if (currentLoadOfTrainset+railRoadCar.getGrossWeight() > trainsetLocomotive.getMaxLocoLoadWeight())
        {throw new Exception("Too much weight for thisd trainset, current weight: " + currentLoadOfTrainset);}
        currentLoadOfTrainset += railRoadCar.getGrossWeight();
        if (this.trainsetCars.contains(railRoadCar)) {throw new Exception("This car is already added to this trainset");}
        trainsetCars.add(railRoadCar);
    }




}

