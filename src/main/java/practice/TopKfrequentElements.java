package practice;


import java.util.*;

public class TopKfrequentElements {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 2, 22, 2, 2, 2, 2, 3};
        int k = 2;
        int[] ans = topKFrequent(array, k);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, (old_value, new_value)->(old_value+new_value));
        }

        // Step 2: Bucket sort — bucket[i] = numbers appearing i times
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(entry.getKey());
        }

        // Step 3: Collect top k from highest bucket down
        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int val : buckets[i]) {
                    result[idx++] = val;
                    if (idx == k) break;
                }
            }
        }
        return result;
    }
}
