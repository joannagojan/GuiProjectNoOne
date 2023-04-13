package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;

public class Trainset <T extends Cars> {
    private Locomotive locomotive;
    private ArrayList<T> cars;
    private Integer trainsetID;
    private Integer IDCounter = 0;
    public Trainset() {
        this.trainsetID = ++trainsetID;
    }

}
