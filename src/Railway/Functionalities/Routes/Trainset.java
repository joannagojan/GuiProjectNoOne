package Railway.Functionalities.Routes;

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
    private Station trainsetSourceStation;
    private Station trainsetStartStation;
    private Station trainsetEndStation;
    private boolean reachedDestination = false;


    public Trainset(Locomotive trainsetLocomotive) throws Exception {
        this.trainsetID = trainsetIDCounter.incrementAndGet();
        this.trainsetLocomotive = trainsetLocomotive;
        this.trainsetSourceStation = trainsetLocomotive.getSourceStation();
        this.trainsetStartStation = trainsetLocomotive.getLocoStartStation();
        this.trainsetEndStation = trainsetLocomotive.getLocoDestinationStation();
        this.howCarConnectedElectricity = 0;
        this.currentLoadOfTrainset = 0;
        if(trainsetLocomotive.getTrainsetID() != null) {
            throw new Exception("This locomotive is assigned to Trainset: " + trainsetLocomotive.getTrainsetID());
        }
        trainsetLocomotive.setTrainsetID(this.trainsetID);
    }

    public void addCar(Cars railRoadCar) throws Exception {
        if(railRoadCar.getTrainsetID() != null) {
            throw new Exception("This railroad car is assigned to another trainset: " + railRoadCar.getTrainsetID());
        }
        if (trainsetLocomotive.getMaxNumberCars() < trainsetCars.size()) {
throw new Exception("Too many cars, this locomotives car limit is: " + trainsetLocomotive.getMaxNumberCars());}
        if (railRoadCar.requiredElectricity()) {
            if (howCarConnectedElectricity <= trainsetLocomotive.getMaxElectricCarsConnected())
                howCarConnectedElectricity++;
        } else throw new Exception("Too many cars connected to electricity grid");
        Integer currentTrainsetWeight = currentLoadOfTrainset+railRoadCar.getGrossWeight();
        if (currentTrainsetWeight > trainsetLocomotive.getMaxLocoLoadWeight())
        {throw new Exception("Gross weight of car you are trying to add is bigger than maximum load of this locomotive. " +
                "This locomotives maximum load is: "
                + trainsetLocomotive.getMaxLocoLoadWeight() + " current weight of the trainset: " + currentTrainsetWeight +
                " and you are trying to add: " + currentTrainsetWeight);}
        currentLoadOfTrainset += railRoadCar.getGrossWeight();
        if (this.trainsetCars.contains(railRoadCar)) {throw new Exception("This car is already added to this trainset");}
        trainsetCars.add(railRoadCar);
        railRoadCar.setTrainsetID(this.trainsetID);
        System.out.println("Car with id: " + railRoadCar.getCarID() + " was successfully added to the trainset with id: "
        + trainsetID);
    }


    public void removeCar(Cars railRoadCar) throws Exception {
        if (railRoadCar.getTrainsetID() == null) {
            throw new Exception("This car is not assigned to any trainset, nothing to remove");
        }
        trainsetCars.remove(railRoadCar);
        System.out.println("Car with ID: " + railRoadCar.getCarID() +
                " was removed from Trainset with ID: " + railRoadCar.getTrainsetID());
    }

    @Override
    public String toString() {
        String message = "This trainset info: " +
                "trainsetID: " + trainsetID +
                "trainset's locomotive: " + trainsetLocomotive +
                "trainset's SourceStation: " + trainsetSourceStation + "trainsetStartStation: " + "trainset's EndStation: " + trainsetEndStation +
                "how many Cars can be connected to electricity grid: " + howCarConnectedElectricity +
                "current Load Of the Trainset: " + currentLoadOfTrainset;
        return message;
    }

    public Locomotive getTrainsetLocomotive() {
        return trainsetLocomotive;
    }

    // 200 km/h means in this 2 seconds in this app
    public AtomicInteger getSpeed() {
        return trainsetLocomotive.getLocomotiveSpeed();
    }
    public boolean isReachedDestination() {
        return reachedDestination;
    }

    public void setReachedDestination(boolean reachedDestination) {
        this.reachedDestination = reachedDestination;
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

    public void setTrainsetID(Integer trainsetID) {
        this.trainsetID = trainsetID;
    }

    public Station getTrainsetSourceStation() {
        return trainsetSourceStation;
    }

    public void setTrainsetSourceStation(Station trainsetSourceStation) {
        this.trainsetSourceStation = trainsetSourceStation;
    }

    public Station getTrainsetStartStation() {
        return trainsetStartStation;
    }

    public void setTrainsetStartStation(Station trainsetStartStation) {
        this.trainsetStartStation = trainsetStartStation;
    }

    public Station getTrainsetEndStation() {
        return trainsetEndStation;
    }

    public void setTrainsetEndStation(Station trainsetEndStation) {
        this.trainsetEndStation = trainsetEndStation;
    }
}

