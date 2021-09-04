import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int n = arr.length;

        // Count the occurences of number
        // and store in count
        for (int i = 0; i < n; i++)
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);

        // Count the occurences of the
        // frequencies
        int[] fre_arr = new int[n + 1];
        for (Integer it : count.values()) {
            fre_arr[it]++;
        }

        // Take answer as total unique numbers
        // and remove the frequency and
        // subtract the answer
        int ans = count.size();

        for (int i = 1; i <= n; i++) {
            if (k <= 0 || k < i) {
                break;
            }
            int temp = fre_arr[i];
            if (temp == 0)
                continue;

            // Remove the minimum number
            // of times
            int t = Math.min(temp, k / i);
            ans -= t;
            k -= i * t;
        }

        // Return the answer
        return ans;
    }

    public static int degree(int[] nums) {
        int ans = nums.length;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Integer> endIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (!map.containsKey(value)) {
                startIndex.put(value, i);
            }
            map.put(value, map.getOrDefault(value, 0) + 1);
            endIndex.put(value, i);
        }

        max = Collections.max(map.values());

        for (int i : map.keySet()) {
            if (map.get(i) == max) {
                int len = endIndex.get(i) - startIndex.get(i) + 1;
                ans = Integer.min(ans, len);
            }
        }
        return ans;
    }

    public static int degree2(int[] nums) {
        int length = nums.length;
        int max = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
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