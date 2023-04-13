package Railway.Functionalities.Trainset;

import Railway.Locomotive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GetRandomLocomotive {
    private List<Locomotive> locomotives;
    private int nextLocomotiveIndex;

    public GetRandomLocomotive(List<Locomotive> locomotives) {
        this.locomotives = new ArrayList<>(locomotives);
        this.nextLocomotiveIndex = 0;
        shuffleLocomotives();
    }

    public Locomotive getLocomotive() {
        if (locomotives.isEmpty()) {
            throw new IllegalStateException("No more available locomotives.");
        }

        if (nextLocomotiveIndex >= locomotives.size()) {
            shuffleLocomotives();
            nextLocomotiveIndex = 0;
        }

        Locomotive locomotive = locomotives.get(nextLocomotiveIndex);
        nextLocomotiveIndex++;
        locomotives.remove(locomotive);
        return locomotive;
    }

    private void shuffleLocomotives() {
        Collections.shuffle(locomotives, ThreadLocalRandom.current());
    }
}
