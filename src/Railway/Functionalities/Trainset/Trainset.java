package Railway.Functionalities.Trainset;

import Railway.CarTypes.Cars;
import Railway.Locomotive;

import java.util.ArrayList;

public class Trainset {
    private Locomotive locomotive;
    private ArrayList<Cars> cars;
    private Integer trainsetID;
    private Integer IDCounter = 0;
    public Trainset() {
        this.trainsetID = ++trainsetID;

    }


}
