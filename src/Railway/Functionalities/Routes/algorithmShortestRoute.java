package Railway.Functionalities.Routes;

import java.util.PriorityQueue;

public class algorithmShortestRoute {

    public void bestRoute(Station startStation){

        startStation.setDistance(0);
        PriorityQueue<Station> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(startStation);
        startStation.setVisited(true);

        while( !priorityQueue.isEmpty() ){
            // Getting the minimum distance vertex from priority queue
            Station currentVisitedStation = priorityQueue.poll();

            for(Route route : currentVisitedStation.getAdjacenciesList()){

                Station endStation = route.getEndStation();
                if(!endStation.isVisited())
                {
                    double newDistance = currentVisitedStation.getDistance() + route.getWeight();

                    if( newDistance < endStation.getDistance() ){
                        priorityQueue.remove(endStation);
                        endStation.setDistance(newDistance);
                        endStation.setPredecessor(currentVisitedStation);
                        priorityQueue.add(endStation);
                    }
                }
            }
            currentVisitedStation.setVisited(true);
        }
    }
}
