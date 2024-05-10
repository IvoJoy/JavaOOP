package checkerForDivisibility;

import java.util.Scanner;

public class checkIfDivisible {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //creating 2 counters
        int totalCount = 0;
        int divisibleBy12Count = 0;

        // looping trough every possible number
        for (int number = 14311; number <= 68798; number++) {
            int firstDigit = number / 10000;
            int secondDigit = (number / 1000) % 10;
            int thirdDigit = (number / 100) % 10;
            int fourthDigit = (number / 10) % 10;
            int fifthDigit = number % 10;
            //storing the digits in 5 variables each time for every number

            //validating them with a helper function that returns boolean value whether
            //their value is in the given range
            if (isValidDigitRange(firstDigit, 1, 6) &&
                    isValidDigitRange(secondDigit, 4, 8) &&
                    isValidDigitRange(thirdDigit, 3, 7) &&
                    isValidDigitRange(fourthDigit, 1, 9) &&
                    isValidDigitRange(fifthDigit, 1, 8)) {
                totalCount++; //pumping the counter if the number's digits are all in their ranges

                //checking for division by 12 and if its divisible we pump the counter
                if (number % 12 == 0) {
                    divisibleBy12Count++;
                }
            }
        }
        //calculating the probability
        double probability = (double) divisibleBy12Count / totalCount;
        double percentProbability = probability * 100;


        System.out.printf("Total count of numbers within the given criteria: %d%n", totalCount);
        System.out.printf("Count of numbers divisible by 12 between them: %d%n", divisibleBy12Count);
        System.out.printf("Probability of a number being divisible by 12: %.4f%n" +
                "Which is %.2f%% chance in percentages.%n ", probability, percentProbability);
    }

    private static boolean isValidDigitRange(int digit, int min, int max) {
        return digit >= min && digit <= max;
    }
}

