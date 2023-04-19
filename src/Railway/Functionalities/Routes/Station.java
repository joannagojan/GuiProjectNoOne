package Railway.Functionalities.Routes;

import java.util.ArrayList;
import java.util.List;

public class Station implements Comparable<Station> {

    // Stations are nodes in the graph. Using Dijkstra's algorithm to get the shortest route
    private String name;
    private List<Route> adjacenciesList;
    private boolean visited;
    private Station predecessor;
    private double distance = Double.MAX_VALUE; // distance starting with available closest value to infinity
    private boolean isOccupied = false;


    public Station(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addNeighbour(Route route) {
        this.adjacenciesList.add(route);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Route> getAdjacenciesList() {
        return adjacenciesList;
    }

    public void setAdjacenciesList(List<Route> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Station getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Station predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Station otherStation) {
        return Double.compare(this.distance, otherStation.getDistance());
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
}