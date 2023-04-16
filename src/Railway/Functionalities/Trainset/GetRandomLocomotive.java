package Railway.Functionalities.Trainset;


import java.util.Random;

public class GetRandomLocomotive {
    // creating an array of integers of available IDs to randomly choose a locomotive or a car
    // using Fisher–Yates shuffle Algorithm
    private static int shuffleArray(int maxID) {
        int counter = 0;

            // creating an array based on max ID availavle
            int[] randomIDArray = new int[maxID];
            for (int i = 0; i < maxID; i++) {
                randomIDArray[i] = i + 1;
            } // fill the array with values from 1 to x
            Random r = new Random();
            int randomInt = 0;
            for (int i = maxID - 1; i > 0; i--) {
                int j = r.nextInt(i + 1);
                int temp = randomIDArray[i];
                randomIDArray[i] = randomIDArray[j];
                randomIDArray[j] = temp;
                randomInt = randomIDArray[counter];
                counter++;
            }
        return randomInt;
    }
}