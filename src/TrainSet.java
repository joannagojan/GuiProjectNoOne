import java.util.ArrayList;
import java.util.List;

public class TrainSet {
    private Locomotive randomLocomotive;
    private List<Cars> carsInTrainSet;

    public TrainSet(Locomotive randomLocomotive, List<Cars> carsInTrainSet) {
        this.randomLocomotive = randomLocomotive;
        this.carsInTrainSet = carsInTrainSet;
    }
}
