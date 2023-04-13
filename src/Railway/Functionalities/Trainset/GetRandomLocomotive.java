package Railway.Functionalities.Trainset;

import Railway.Locomotive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GetRandomLocomotive {
    private List<Locomotive> availableLocomotives;
    private int nextLocomotiveIndex;
    private Random random;

    public GetRandomLocomotive(List<Locomotive> availableLocomotives) {
        this.availableLocomotives = new ArrayList<>(availableLocomotives);
        this.nextLocomotiveIndex = 0;
        this.random = new Random();
        shuffleLocomotives();
    }

    public Locomotive getNextLocomotive() {
        if (availableLocomotives.isEmpty()) {
            throw new IllegalStateException("No more available locomotives.");
        }

        if (nextLocomotiveIndex >= availableLocomotives.size()) {
            shuffleLocomotives();
            nextLocomotiveIndex = 0;
        }

        Locomotive locomotive = availableLocomotives.get(nextLocomotiveIndex);
        nextLocomotiveIndex++;
        availableLocomotives.remove(locomotive);
        return locomotive;
    }

    private void shuffleLocomotives() {
        Collections.shuffle(availableLocomotives, random);
    }
}
