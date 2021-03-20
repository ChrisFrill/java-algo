package main.java.sort;

import main.java.Utils;

public class SelectionSort {
    private static void sort(int[] arr) {
        Utils.printArray(arr);

        // temporary variable to store the position of minimum element
        int min;
        // reduces the effective size of the array by one in  each iteration.
        for (int i = 0; i < arr.length - 1; i++) {
            // assuming the first element to be the minimum of the unsorted array .
            min = i;
            // gives the effective size of the unsorted  array .
            for (int j = i + 1; j < arr.length; j++ ) {
                if (arr[j] < arr[min]) { //finds the minimum element
                    min = j;
                }
            }
            // swapping, putting minimum element on its proper position.
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            Utils.printArray(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        sort(arr);
        Utils.printArray(arr);
    }
}
