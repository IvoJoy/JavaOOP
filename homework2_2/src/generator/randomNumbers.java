package generator;

import java.text.NumberFormat;
import java.util.Random;

public class randomNumbers {

    private static final Random random = new Random();

    //random number only between 0 and 9 which makes 0,1 return 1;
    // 2,3,4 return 2 and 5,6,7,8,9 return 3
    public static int drawRandomNumber() {
        double rand = random.nextDouble() * 10;
        if (rand < 2) {
            return 1;
        } else if (rand < 5) {
            return 2;
        } else {
            return 3;
        }
    }

    public static void main(String[] args) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(2);
// we test with 10,000 iterations
        int iterations1 = 10000;
        int[] counts1 = new int[3];

        for (int i = 0; i < iterations1; i++) {
            int randomNumber = drawRandomNumber();
            counts1[randomNumber - 1]++;
        }
//printing the results (different every time but close enough to the probabilities -
// around 20% 1s, 30% 2s and 50% 3s)
        System.out.println("Results after " + iterations1 + " iterations:");
        for (int i = 0; i < counts1.length; i++) {
            double probability = (double) counts1[i] / iterations1;
            System.out.println("Probability of " + (i + 1) + ": " + percentFormat.format(probability));
        }
// then we test with 60,000 iterations
        int iterations2 = 60000;
        int[] counts2 = new int[3];

        for (int i = 0; i < iterations2; i++) {
            int randomNumber = drawRandomNumber();
            counts2[randomNumber - 1]++;
        }

//printing the results (different every time but close enough to the probabilities -
// around 20% 1s, 30% 2s and 50% 3s)
        System.out.println("\nResults after " + iterations2 + " iterations:");
        for (int i = 0; i < counts2.length; i++) {
            double probability = (double) counts2[i] / iterations2;
            System.out.println("Probability of " + (i + 1) + ": " + percentFormat.format(probability));
        }
    }
}