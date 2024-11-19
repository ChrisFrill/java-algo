package main.java.buildingblocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysBuildingBlock {
    Integer[] arr = new Integer[10];
    Integer[] arr2 = new Integer[10];
    String[] strings = new String[10];
    int[][] arr3 = new int[10][10];
    {
        Arrays.equals(arr, arr2);
        Arrays.sort(arr);
        Arrays.asList(1, 2, 3);
        Arrays.binarySearch(arr, 10);
        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.deepToString(strings);
        Collections.max(Arrays.asList(arr));
        Collections.min(Arrays.asList(arr));

        // Array to set
        List<Character> ch2 = new ArrayList<>();
        "asd".chars().forEach(ch -> ch2.add((char )ch));
    }
}
