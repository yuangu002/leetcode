import java.util.*;

public class SubarrayEqualsK {
    public int subarraySum(int[] nums, int k) {
        // i - j: prefix[j+1] - [i]
        // prefix[j+1] - prefix[i] = k
        // find if there is start: prefix[end] - k

        /** The hashmap stores a pair (current prefix, count) */

        // [1, 2, 2, 3, 4, 5, 7, 8]
        // 12
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int total_cnt = 0;
        int running_sum = 0;

        // to cover the "right from start" situation
        hmap.put(running_sum, 1);

        // iterate the array, check three things
        // 1. increment the running sum
        // 2. if (running_sum - k) exists in the hashmap, it means that there's subarrays with k sum
        // 3. put running_sum back to the hashmap with incrementing its count by 1
        for (int i = 0; i < nums.length; ++i) {
            running_sum += nums[i];
            
            if (hmap.containsKey(running_sum - k)) {
                total_cnt += hmap.get(running_sum - k);
            }
            hmap.put(running_sum, hmap.getOrDefault(running_sum, 0) + 1);
        }
        return total_cnt;
    }
}
