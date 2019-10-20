package arrays;

import java.util.Arrays;

public class ReverseArrayChallenge {

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int reversedIndex = maxIndex - i;
            int temp = array[i];
            array[i] = array[reversedIndex];
            array[reversedIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println("Array before: " + Arrays.toString(array));
        reverse(array);
        System.out.println("Array after: " + Arrays.toString(array));
    }
}
