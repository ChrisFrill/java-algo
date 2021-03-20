package main.java.sort;

import main.java.Utils;

public class InsertionSort {
    private static void sort(int[] arr) {
        Utils.printArray(arr);

        for (int i = 1; i < arr.length; i++) {
            // Key is fixed
            int key = arr[i];
            // j is decreased until key is in right place
            int j = i;

            // Move elements of the array, that are greater than key,
            // to one position ahead of their current position
            while (j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j = j - 1;
            }
            // Insert the key to the freed up position
            arr[j] = key;

            Utils.printArray(arr);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        sort(arr);
        Utils.printArray(arr);
    }
}
