package main.java.search;

// Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
// Time complexity: O(Log n)
// 1 2 3 4 5
// 1 2 3 4 5 6

import java.util.Arrays;

public class BinarySearch {
    private static int search(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            //         1   + (  5   -   1 ) / 2  = 2.5
            //         1   + (  6   -   1 ) / 2  = 3
            int mid = left + (right - left) / 2;
            System.out.println("Left element: " + left);
            System.out.println("Right element: " + right);
            System.out.println("Middle element: " + mid);
            System.out.println("---");

            // Check if x is present at mid
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] <= x) { // If x greater, ignore left half
                left = mid + 1;
            } else {  // If x is smaller, ignore right half
                right = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6}, 5));
    }

}
