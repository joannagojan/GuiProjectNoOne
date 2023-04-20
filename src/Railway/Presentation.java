package Railway;

import Railway.CarTypes.*;
import Railway.Functionalities.CarRelated.Cargo;
import Railway.Functionalities.Routes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Presentation {
    public static void main(String[] args) throws Exception {

        try {
            String[] stationNames = {"Perth", "Elizabeth Quay", "Perth Underground", "Esplanade", "McIver", "Claisebrook", "East Perth",
                    "Maylands", "Meltham", "Bayswater", "Ashfield", "Bassendean", "Success Hill", "Guildford", "Woodbridge", "East Guildford",
                    "Hazelmere", "Midland", "Woodbridge", "Woodbridge Riverside Park", "Stratton", "Altone Park", "Beechboro", "Whiteman Park",
                    "Malaga", "Ballajura", "Mirrabooka", "Nollamara", "Stirling", "Karrinyup", "Warwick", "Greenwood", "Whitfords", "Mullaloo",
                    "Ocean Reef", "Heathridge", "Edgewater", "Joondalup", "Currambine", "Clarkson", "Butler", "Jindalee", "Alkimos", "Eglinton",
                    "Yanchep", "Guilderton", "Gingin", "Lancelin", "Moore River", "Leeman", "Green Head", "Dongara", "Irwin", "Mingenew", "Morawa",
                    "Perenjori", "Three Springs", "Carnamah", "Eneabba", "Badgingarra", "Cervantes", "Jurien Bay", "Green Head", "Leeman",
                    "Dongara", "Geraldton", "Strathalbyn", "Mt. Tarcoola", "Wandina", "Drummond Cove", "Sunset Beach", "Beachlands", "Waggrakine",
                    "Utakarra", "Glenfield", "Karloo", "Spalding", "Mount Magnet", "Yalgoo", "Paynes Find", "Sandstone", "Leinster", "Wiluna",
                    "Cue", "Morawa", "Binnu", "Kalbarri", "Northampton", "Ajana", "Bowes", "Perenjori", "Bancannia", "Paynesville", "Mullewa",
                    "Walkaway", "Beecher", "Nanson", "Warradarge", "Burdett", "Urawa", "Arrino", "Marchagee", "Eradu", "Gunyidi", "Mogumber",
                    "Coorow", "Miling", "New Norcia", "Bolgart", "Dandaragan", "Regans Ford", "Cataby", "Cervantes", "Jurien Bay"};

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

                do {
// adding random neibors so every station has at least 10
                    int randomIndex = (int) (Math.random() * stationsList.size());
                    Station randomStation = stationsList.get(randomIndex);

                    if (!station.equals(randomStation) && !adjacenciesList.contains(randomStation)) {
                        double weight = Math.round(Math.random() * 10);
                        Route route = new Route(weight, station, randomStation);
                        routes.add(route);
                        station.addNeighbour(route);
                    }
                } while (adjacenciesList.size() <= 10);
            }

            System.out.println("Created Routes:");
            for (Route route : routes) {
                System.out.println("Start station: " + route.getStartStation() + " end station: " + route.getEndStation()
                        + ", weight: " + route.getWeight()
                );
            }


            // Creating Locomotives, trainsets and threads
            ArrayList<Locomotive> allLocomotives = new ArrayList<>();
            ArrayList<Trainset> allTrainsets = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                ArrayList<Station> newstationList = stationsList;
                int randomSourceInt = (int) (Math.random() * newstationList.size());
                Station randomSource = newstationList.get(randomSourceInt);
                int randomStartStationInt = (int) (Math.random() * newstationList.size());
                Station randomStartStation = newstationList.get(randomStartStationInt);
                newstationList.remove(randomSource);
                newstationList.remove(randomStartStation);
                int randomEndStationInt = (int) (Math.random() * newstationList.size());
                Station randomEndStation = newstationList.get(randomEndStationInt);
                String alphabet = "abcdefghijklmnopqrstuvwxyzabcd";
                String name = alphabet.substring(i, i + 1);
                Integer maxElectricCarsConnected = (int) ((Math.random() * 10));
                Integer maxLoad = (int) ((Math.random() * (30000 - 15000)) + 15000);
                Integer maxSpeedInt = (int) ((Math.random() * (250 - 100)) + 100);
                AtomicInteger maxSpeed = new AtomicInteger(maxSpeedInt);
                Integer maxCarsConnected = (int) ((Math.random() * 10) + 1);
                Locomotive locomotive = new Locomotive(name, randomSource, randomStartStation,
                        randomEndStation, maxCarsConnected, maxLoad, maxSpeed, maxElectricCarsConnected);
                Trainset trainset = new Trainset(locomotive);
                allLocomotives.add(locomotive);
                allTrainsets.add(trainset);

            }
            List<Thread> allThreads = new ArrayList<>();

            for (Trainset trainset : allTrainsets) {
                Station startStation = trainset.getTrainsetStartStation();
                Station endStation = trainset.getTrainsetEndStation();
                Station sourceStation = trainset.getTrainsetSourceStation();
                GetBestRoute shortestPath = new GetBestRoute();
                shortestPath.getBestRoute(sourceStation);
                List<Station> fromSourceToStartBestPath = shortestPath.getShortestPathTo(startStation);
                System.out.println("this trainsets : " + trainset.getTrainsetID()
                        + " best path from source to start is: ");
                MovingTrainsets movingTrainsets = new MovingTrainsets(trainset, allTrainsets);
                movingTrainsets.appStateFile();
                Thread thread = new Thread(movingTrainsets);
                allThreads.add(thread);
                thread.start();
                for (Station station : fromSourceToStartBestPath) {
                    System.out.println(station);
                }
                shortestPath.getBestRoute(startStation);
                List<Station> fromStartToEndBestPath = shortestPath.getShortestPathTo(endStation);
                System.out.println("this trainsets: " + trainset.getTrainsetID()
                        + " best path is: "
                );
                for (Station station : fromStartToEndBestPath) {
                    System.out.println(station);
                }
            }

            PassengerCar pasCarGood = new PassengerCar(10);
            PassengerCar pasCarBad = new PassengerCar(-1);
            Cargo newCargoGood = new Cargo("Transported cargo", "Non toxic", 2, 50,
                    30, 500, 50, 200);
            Cargo newCargoBad = new Cargo("Transported cargo", "Non toxic", 2, 50,
                    30000, 500, 50, 200);
            BaggageAndMailCar bagCarGood = new BaggageAndMailCar();
            bagCarGood.addCargo(newCargoGood);
            bagCarGood.addCargo(newCargoBad);
            ExplosivesCar explosivesCar = new ExplosivesCar(3);
            GaseousMatCar gaseousMatCar = new GaseousMatCar();
            PostOfficeCar postOfficeCar = new PostOfficeCar(300);
            RestaurantCar restaurantCar = new RestaurantCar(10, 2);
            ToxicMatCar toxicMatCar = new ToxicMatCar(10);
            ToxicLiquidMatCar toxicLiquidMatCar = new ToxicLiquidMatCar();

            Cargo explosive = new Cargo("Explosive mat", "Bomb", 10, 50,
                    30000, 500, 50, 200);

            explosivesCar.addCargo(explosive);

            allTrainsets.get(0).addCar(pasCarGood);
            allTrainsets.get(1).addCar(pasCarBad);
            allTrainsets.get(1).addCar(bagCarGood);


            try {
                for (Thread thread : allThreads) {
                    thread.join();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            System.out.println("Exception; " + e);
        }
    }
}
