package main.java;

import java.util.*;

public class DegreeOfArray {

    public static int degreeOfArray(List<Integer> arr) {
        int ans = arr.size();
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Integer> endIndex = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            int value = arr.get(i);
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                startIndex.put(value, i);
                map.put(value, 1);
            }
            endIndex.put(value, i);
        }

        max = Collections.max(map.values());

        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                int length = endIndex.get(i) - startIndex.get(i) + 1;
                ans = Integer.min(ans, length);
            }
        }
        return ans;
    }

    public static int degree2(List<Integer> arr) {
        int length = arr.size();
        int max = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int value = arr.get(i);
            if (!map.containsKey(value)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(value, list);
            } else {
                map.get(value).add(i);
            }
        }

        for (List<Integer> indices : map.values()) {
            int actualLength = indices.get(indices.size() - 1) - indices.get(0) + 1;
            if (indices.size() > max) {
                max = indices.size();
                length = actualLength;
            } else if (indices.size() == max) {
                length = Math.min(length, actualLength);
            }
        }
        return length;
    }
}
