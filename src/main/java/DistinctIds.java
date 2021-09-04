package main.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctIds {
    static int distinctIds(List<Integer> ids, int m) {
        // 1 1 2 2 2 3 3 4 5
        Map<Integer, Integer> count = new HashMap<>();
        int size = ids.size();

        for (Integer id : ids) {
            count.put(id, count.getOrDefault(id, 0) + 1);
        }
        /**
         1 2
         2 3
         3 2
         4 1
         5 1
         **/

        int[] frequencies = new int[size + 1];
        for (Integer value : count.values()) {
            frequencies[value]++;
        }
        //0 1 2 3
        //0 2 2 1

        int ans = count.size();

        for (int i = 1; i < size; i++) {
            if (m <= 0 || m < i) {
                break;
            } else {
                int frequency = frequencies[i];
                if (frequency == 0) {
                    continue;
                }
                // 2 vs 8 / 2 -> 2
                // 2 vs 3 / 2 -> 1
                int min = Math.min(frequency, m / i);

                // decrease unique elements
                ans -= min;
                // decrease how much we can remove still by removed elements number X frequency
                // 8 - (2 * 2)
                // 3 - (2 * 1)
                m -= i * min;
            }
        }
        return ans;
    }
}