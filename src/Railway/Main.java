package Railway;//package Railway;

import Railway.CarTypes.Cars;
import Railway.CarTypes.PostOfficeCar;
import Railway.Functionalities.Routes.AlgorithmShortestRoute;
import Railway.Functionalities.Routes.GetBestRoute;
import Railway.Functionalities.Routes.Route;
import Railway.Functionalities.Routes.Station;
import Railway.Functionalities.Trainset.Trainset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        try {
            Station st1 = new Station("d");

            Locomotive loco1 = new Locomotive("g", st1, st1, 1, 10000, 4, 5);
            Locomotive loco2 = new Locomotive("g", st1, st1, 1, 10000, 4, 5);
            Locomotive loco3 = new Locomotive("g", st1, st1, 1, 10000, 4, 5);
            Locomotive loco4 = new Locomotive("g", st1, st1, 1, 10000, 4, 4);
            Locomotive loco5 = new Locomotive("g", st1, st1, 1, 10000, 4, 3);

            PostOfficeCar car1 = new PostOfficeCar();
            PostOfficeCar car3 = new PostOfficeCar();
            PostOfficeCar car2 = new PostOfficeCar();

            System.out.println("max id" + Cars.getMaxId());
            Trainset tset1 = new Trainset(loco1);
            tset1.addCar(car1);
            Trainset tset2 = new Trainset(loco2);
            tset1.addCar(car2);
            tset1.removeCar(car2);

            String[] stationNames = {
                    "Perth",
                    "Elizabeth Quay",
                    "Perth Underground",
                    "Esplanade",
                    "McIver",
                    "Claisebrook",
                    "East Perth",
                    "Maylands",
                    "Meltham",
                    "Bayswater",
                    "Ashfield",
                    "Bassendean",
                    "Success Hill",
                    "Guildford",
                    "Woodbridge",
                    "East Guildford",
                    "Hazelmere",
                    "Midland",
                    "Woodbridge",
                    "Woodbridge Riverside Park",
                    "Stratton",
                    "Altone Park",
                    "Beechboro",
                    "Whiteman Park",
                    "Malaga",
                    "Ballajura",
                    "Mirrabooka",
                    "Nollamara",
                    "Stirling",
                    "Karrinyup",
                    "Warwick",
                    "Greenwood",
                    "Whitfords",
                    "Mullaloo",
                    "Ocean Reef",
                    "Heathridge",
                    "Edgewater",
                    "Joondalup",
                    "Currambine",
                    "Clarkson",
                    "Butler",
                    "Jindalee",
                    "Alkimos",
                    "Eglinton",
                    "Yanchep",
                    "Guilderton",
                    "Gingin",
                    "Lancelin",
                    "Moore River",
                    "Leeman",
                    "Green Head",
                    "Dongara",
                    "Irwin",
                    "Mingenew",
                    "Morawa",
                    "Perenjori",
                    "Three Springs",
                    "Carnamah",
                    "Eneabba",
                    "Badgingarra",
                    "Cervantes",
                    "Jurien Bay",
                    "Green Head",
                    "Leeman",
                    "Dongara",
                    "Geraldton",
                    "Strathalbyn",
                    "Mt. Tarcoola",
                    "Wandina",
                    "Drummond Cove",
                    "Sunset Beach",
                    "Beachlands",
                    "Waggrakine",
                    "Utakarra",
                    "Glenfield",
                    "Karloo",
                    "Spalding",
                    "Mount Magnet",
                    "Yalgoo",
                    "Paynes Find",
                    "Sandstone",
                    "Leinster",
                    "Wiluna",
                    "Cue",
                    "Morawa",
                    "Binnu",
                    "Kalbarri",
                    "Northampton",
                    "Ajana",
                    "Bowes",
                    "Perenjori",
                    "Bancannia",
                    "Paynesville",
                    "Mullewa",
                    "Walkaway",
                    "Beecher",
                    "Nanson",
                    "Warradarge",
                    "Burdett",
                    "Urawa",
                    "Arrino",
                    "Marchagee",
                    "Eradu",
                    "Gunyidi",
                    "Mogumber",
                    "Coorow",
                    "Miling",
                    "New Norcia",
                    "Bolgart",
                    "Dandaragan",
                    "Regans Ford",
                    "Cataby",
                    "Cervantes",
                    "Jurien Bay"
            };


                    // Create an ArrayList to store the stations and routes
                    ArrayList<Station> stationsList = new ArrayList<>();
                    ArrayList<Route> routes = new ArrayList<>();

                    // Create stations
                    for (String stationName : stationNames) {
                        Station station = new Station(stationName);
                        stationsList.add(station);
                    }


            for (Station station : stationsList) {
                List<Route> adjacenciesList = station.getAdjacenciesList();

                // Keep generating random neighbors until the station has at least 3 neighbors
                do {
                    // Generate random index to select a neighbor from the stationsList
                    int randomIndex = (int) (Math.random() * stationsList.size());
                    Station randomStation = stationsList.get(randomIndex);

                    // Check if the random station is not the same as the current station and is not already a neighbor
                    if (!station.equals(randomStation) && !adjacenciesList.contains(randomStation)) {
                        double weight = Math.random() * 10; // Example weight, you can modify as needed
                        Route route = new Route(weight, station, randomStation);
                        station.addNeighbour(route);
                    }
                } while (adjacenciesList.size() < 3); // Repeat until the station has at least 3 neighbors
            }

            // Print the created routes
            System.out.println("Created Routes:");
            for (Route route : routes) {
                System.out.println("Start station: " + route.getStartStation() + " end station: " + route.getEndStation()
                        + " weight: " + route.getWeight()
                );
            }

            GetBestRoute shortestPath = new GetBestRoute();
            shortestPath.getBestRoute(stationsList.get(0));
            List<Station> x = shortestPath.getShortestPathTo(stationsList.get(11));
            System.out.println();
            System.out.println("List of Stations:");
            for (Station station : x) {
                System.out.println(station);
            }

        } catch (Exception e) {
            System.out.println("Exception; " + e);
        }
    }
}
