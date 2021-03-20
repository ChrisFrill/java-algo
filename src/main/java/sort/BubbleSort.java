package main.java.sort;

// Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

import main.java.Utils;

public class BubbleSort {
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // If the first element is greater than the next, swap them
                // The iteration length is decreasing, the tail will be in sorted order first
                // On each iteration a new high number is getting to the end of the ("new") shortened array like a bubble rising up
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
        System.out.println("Sorted array");
        Utils.printArray(arr);
    }
}
