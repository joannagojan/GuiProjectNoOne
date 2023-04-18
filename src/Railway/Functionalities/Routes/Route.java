package Railway.Functionalities.Routes;

import Railway.Functionalities.Routes.Station;

public class Route {

    // routes are edges in the graph

    private double weight;
    private Station startStation;
    private Station endStation;

    public Route(double weight, Station startStation, Station endStation) {
        this.weight = weight;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }
}