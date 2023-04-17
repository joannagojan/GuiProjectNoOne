//package Railway.Functionalities.Trainset;
//
//import java.util.Random;
//
//public class GetRandomCar {
//    private static Random r = new Random();
//
//    // creating an array from numbers to choose random locomotives and cars
//    public int getRandomID(int maxID) throws Exception {
//        int counter = 0;
//        int[] randomIDArray = new int[maxID];
//        for (int i = 0; i < maxID; i++) {
//            randomIDArray[i] = i + 1;
//        }
//        for (int i = maxID - 1; i > 0; i--) {
//            int j = r.nextInt(i + 1);
//            int temp = randomIDArray[i];
//            randomIDArray[i] = randomIDArray[j];
//            randomIDArray[j] = temp;
//        }
//        if (counter > maxID) {
//            throw new Exception("No more available Cars or locomotives");
//        }
//        int randomInt = randomIDArray[counter];
//        ++counter;
//        return randomInt;
//    }
//}
