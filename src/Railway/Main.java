package Railway;

import Railway.Functionalities.TransportedMaterials;

public class Main {
    public static void main(String[] args) {
        Station st1 = new Station("d");

Locomotive loco1 = new Locomotive("g", st1, st1, 1, 6000, 4);
Locomotive loco2 = new Locomotive("g", st1, st1, 1, 6000, 4);
Locomotive loco3 = new Locomotive("g", st1, st1, 1, 6000, 4);
Locomotive loco4 = new Locomotive("g", st1, st1, 1, 6000, 4);
Locomotive loco5 = new Locomotive("g", st1, st1, 1, 6000, 4);

System.out.println(loco5.getLocomotiveID());
}}