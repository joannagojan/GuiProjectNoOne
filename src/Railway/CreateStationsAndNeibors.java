package Railway;

import java.util.ArrayList;
import java.util.List;

public class CreateStationsAndNeibors {
    List<Station> stations = new ArrayList<>();
    public void createStationandItsNeibors() {
        for (int i = 0; i < 100; i++) {
        stations.add(new Station());
        }
  for (int i = 0; i < 100; i++) {
        Station s = stations.get(i);
        List<Integer> randomNums = getRandomNumbers(0, 100, Math.random(0, 100));
        List<Station> neighbors = new LinkedList<>();
        for(int num: randomNums) {
            neighbors.add(stations.get(num));
        }
        // a <=> b a.neighbors should contain b, b.neighbors should contain A.
        s.setNeighbors(neighbors);
    }
    }
}
