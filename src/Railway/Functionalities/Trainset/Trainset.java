package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Trainset {
    private Locomotive trainsetLocomotive;
    private ArrayList<Cars> trainsetCars = new ArrayList<>();;
    private static final AtomicInteger trainsetIDCounter = new AtomicInteger(0);
    private Integer trainsetID;
    private Integer howCarConnectedElectricity;
    private Integer currentLoadOfTrainset;

    public Trainset(Locomotive trainsetLocomotive) throws Exception {
        this.trainsetID = trainsetIDCounter.incrementAndGet();
        this.trainsetLocomotive = trainsetLocomotive;
        this.howCarConnectedElectricity = 0;
        this.currentLoadOfTrainset = 0;
        if(trainsetLocomotive.getTrainsetID() != null) {
            throw new Exception("This locomotive is assigned to Trainset: " + trainsetLocomotive.getTrainsetID());
        }
        trainsetLocomotive.setTrainsetID(this.trainsetID);
    }

    public void addCar(Cars railRoadCar) throws Exception {
        if (trainsetLocomotive.getMaxNumberCars() < trainsetCars.size()) {
throw new Exception("Too many cars, this locomotives car limit is: " + trainsetLocomotive.getMaxNumberCars());}
        if (railRoadCar.requiredElectricity()) {
            if (howCarConnectedElectricity <= trainsetLocomotive.getMaxElectricCarsConnected())
                howCarConnectedElectricity++;
        } else throw new Exception("Too many cars connected to electricity grid");
        Integer currentTrainsetWeight = currentLoadOfTrainset+railRoadCar.getGrossWeight();
        if (currentTrainsetWeight > trainsetLocomotive.getMaxLocoLoadWeight())
        {throw new Exception("Gross weight of car you are trying to add is too big max load of this locomotive is: "
                + trainsetLocomotive.getMaxLocoLoadWeight() + " current weight of the trainset: " + currentTrainsetWeight +
                "and you are trying to add: " + currentTrainsetWeight);}
        currentLoadOfTrainset += railRoadCar.getGrossWeight();
        if (this.trainsetCars.contains(railRoadCar)) {throw new Exception("This car is already added to this trainset");}
        trainsetCars.add(railRoadCar);
        System.out.println("Car with id: " + railRoadCar.getCarID() + " was successfully added to the trainset with id: "
        + trainsetID);
    }


    public Locomotive getTrainsetLocomotive() {
        return trainsetLocomotive;
    }

    public void setTrainsetLocomotive(Locomotive trainsetLocomotive) {
        this.trainsetLocomotive = trainsetLocomotive;
    }

    public ArrayList<Cars> getTrainsetCars() {
        return trainsetCars;
    }

    public void setTrainsetCars(ArrayList<Cars> trainsetCars) {
        this.trainsetCars = trainsetCars;
    }

    public Integer getTrainsetID() {
        return trainsetID;
    }


    public Integer getHowCarConnectedElectricity() {
        return howCarConnectedElectricity;
    }

    public void setHowCarConnectedElectricity(Integer howCarConnectedElectricity) {
        this.howCarConnectedElectricity = howCarConnectedElectricity;
    }

    public Integer getCurrentLoadOfTrainset() {
        return currentLoadOfTrainset;
    }

    public void setCurrentLoadOfTrainset(Integer currentLoadOfTrainset) {
        this.currentLoadOfTrainset = currentLoadOfTrainset;
    }
}

