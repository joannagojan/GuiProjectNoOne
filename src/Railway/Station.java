package Railway;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Station {
    private String name;
    private ArrayList<Station> neighbors;

    private static final AtomicInteger stationIDCounter = new AtomicInteger(0);
    private final Integer stationID;

    public Station() {
        this.neighbors = new ArrayList<>();
        this.stationID = stationIDCounter.incrementAndGet();
    }

    public void setName(String name) {
        this.name = name;
    }

}