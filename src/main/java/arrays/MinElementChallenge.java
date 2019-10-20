package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinElementChallenge {

    private static Scanner scanner = new Scanner(System.in);

    private static int[] readIntegers(int count) {
        int[] array = new int[count];
        System.out.println("Enter " + count + " integer values:\r");
        for (int i = 0; i < array.length; i++) {
            int number = scanner.nextInt();
            scanner.nextLine();
            array[i] = number;
        }
        return array;
    }

    private static int findMin(int[] array) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        int[] array = readIntegers(5);
        System.out.println("Minimal value of the array: \n" + Arrays.toString(array) + "\n is: " + findMin(array));
    }

}