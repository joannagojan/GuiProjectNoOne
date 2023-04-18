package Railway.Functionalities.Routes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class getBestRoute {

        public void getBestRoute(Station startStation){

            startStation.setDistance(0);
            PriorityQueue<Station> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(startStation);
            startStation.setVisited(true);

            while( !priorityQueue.isEmpty() ){
                // Getting the minimum distance vertex from priority queue
                Station currentStation = priorityQueue.poll();

                for(Route route : currentStation.getAdjacenciesList()){

                    Station endStation = route.getEndStation();
                    if(!endStation.isVisited())
                    {
                        double newDistance = currentStation.getDistance() + route.getWeight();

                        if( newDistance < endStation.getDistance() ){
                            priorityQueue.remove(endStation);
                            endStation.setDistance(newDistance);
                            endStation.setPredecessor(currentStation);
                            priorityQueue.add(endStation);
                        }
                    }
                }
                currentStation.setVisited(true);
            }
        }

    public List<Station> getShortestPathTo(Station endStation){
        List<Station> path = new ArrayList<>();

        for(Station station=endStation;station!=null;station=station.getPredecessor()){
            path.add(station);
        }

        Collections.reverse(path);
        return path;
    }

    }

