package main.java.search;

// Given an array arr[] of n elements, write a function to search a given element x in arr[].
// Time complexity: O(n)

public class LinearSearch {
    public static int search(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
