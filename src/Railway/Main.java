package Railway;

import Railway.CarTypes.Cars;
import Railway.CarTypes.PostOfficeCar;
import Railway.Functionalities.TransportedMaterials;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        Station st1 = new Station("d");

        Locomotive loco1 = new Locomotive("g", st1, st1, 1, 6000, 4, 5);
        Locomotive loco2 = new Locomotive("g", st1, st1, 1, 6000, 4,5);
        Locomotive loco3 = new Locomotive("g", st1, st1, 1, 6000, 4,5);
        Locomotive loco4 = new Locomotive("g", st1, st1, 1, 6000, 4,4 );
        Locomotive loco5 = new Locomotive("g", st1, st1, 1, 6000, 4, 3);

PostOfficeCar car1 = new PostOfficeCar();
PostOfficeCar car3 = new PostOfficeCar();
PostOfficeCar car2 = new PostOfficeCar();

        System.out.println("max id" + Cars.getMaxId());

//
//        int locoIDmax = Locomotive.getLocomotiveCounterMax();
//        ArrayList<Locomotive> alllocos = new ArrayList<>();
//        for (int i = 0; i < (int)locoIDmax; i++) {
//            alllocos.add(Locomotive.i);
//
//        }


    }
}