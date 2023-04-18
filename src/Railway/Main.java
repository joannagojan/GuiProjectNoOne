package Railway;

import Railway.CarTypes.Cars;
import Railway.CarTypes.PostOfficeCar;
import Railway.Functionalities.Routes.AlgorithmShortestRoute;
import Railway.Functionalities.Routes.GetBestRoute;
import Railway.Functionalities.Routes.Route;
import Railway.Functionalities.Routes.Station;
import Railway.Functionalities.Trainset.Trainset;

import java.util.ArrayList;
import java.util.List;

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

            ArrayList<Station> allstations = new ArrayList<>();
            // Creating stations based on the station names list
            Station[] stations = new Station[stationNames.length];
            for (int i = 0; i < stationNames.length; i++) {
                stations[i] = new Station(stationNames[i]);
                allstations.add(stations[i]);
            }
            System.out.println("Name of the first station: " + stations[0].getName());

            ArrayList<Route> routes = new ArrayList<>();

            for (int i = 0; i < allstations.size(); i++) {
                Station startStation = allstations.get(i);
                Station endStation;
                do {
                    endStation = allstations.get((int) (Math.random() * allstations.size()));
                } while (startStation.equals(endStation)); // Ensure start and end stations are not the same

                double weight = Math.round(Math.random() * 10 + 1); // Generate random weight between 1 and 10
                Route route = new Route(weight, startStation, endStation);
                routes.add(route);
            }

            // Print the created routes
            System.out.println("Created Routes:");
            for (Route route : routes) {
                System.out.println("Start station: " + route.getStartStation() + " end station: " + route.getEndStation()
                        + " weight: " + route.getWeight()
                );
            }

            GetBestRoute shortestPath = new GetBestRoute();
            shortestPath.getBestRoute(stations[0]);
            List<Station> x = shortestPath.getShortestPathTo(stations[11]);
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