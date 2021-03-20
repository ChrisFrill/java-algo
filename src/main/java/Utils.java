package main.java;

import java.util.Arrays;

public class Utils {
    /* Prints the array */
    public static void printArray(int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void print2DArray(int[][] arr) {
        System.out.println(Arrays.deepToString(arr));
    }
}
