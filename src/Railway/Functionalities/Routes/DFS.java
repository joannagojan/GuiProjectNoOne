//package Railway.Functionalities.Routes;
//
//public class DFS {
//    // Connect stations with at least 3 randomly chosen neighbors
//    connectStations(stationsList, 3);
//
//    // Perform DFS from the first station in the list
//    boolean[] visited = new boolean[stationsList.size()];
//    dfs(stationA, visited);
//
//    // Check if all stations are visited
//    boolean isConnected = true;
//        for (boolean v : visited) {
//        if (!v) {
//            isConnected = false;
//            break;
//        }
//    }
//
//        if (isConnected) {
//        System.out.println("All stations are connected.");
//    } else {
//        System.out.println("Not all stations are connected.");
//    }
//}
//
//    // Method to connect stations with at least numConnections randomly chosen neighbors
//    public static void connectStations(List<Station> stationsList, int numConnections) {
//        Random random = new Random();
//        for (Station station : stationsList) {
//            // Shuffle the stations list
//            List<Station> shuffledList = new ArrayList<>(stationsList);
//            shuffledList.remove(station); // Remove the current station from the list
//            for (int i = shuffledList.size() - 1; i > 0; i--) {
//                int j = random.nextInt(i + 1);
//                Station temp = shuffledList.get(i);
//                shuffledList.set(i, shuffledList.get(j));
//                shuffledList.set(j, temp);
//            }
//
//            // Connect the station with the first numConnections shuffled stations
//            for (int i = 0; i < numConnections; i++) {
//                station.addNeighbour(new Route(station, shuffledList.get(i)));
//            }
//        }
//    }
//
//    // DFS method to traverse the graph and mark visited stations
//    public static void dfs(Station station, boolean[] visited) {
//        visited[station.getName().charAt(0) - 'A'] = true;
//        List<Route> adjacenciesList = station.getAdjacenciesList();
//        for (Route route : adjacenciesList) {
//            Station neighbor = route.getEndStation();
//            if (!visited[neighbor.getName().charAt(0) - 'A']) {
//                dfs(neighbor, visited);
//            }
//        }
//}
