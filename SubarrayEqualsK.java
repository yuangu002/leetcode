import java.util.*;

public class SubArrayEqualsK {
    public int subarraySum(int[] nums, int k) {
        // i - j: prefix[j+1] - [i]
        // prefix[j+1] - prefix[i] = k
        // find if there is start: prefix[end] - k
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int total_cnt = 0;
        int running_sum = 0;
        hmap.put(running_sum, 1);
        for (int i = 0; i < nums.length; ++i) {
            running_sum += nums[i];
            
            if (hmap.containsKey(running_sum - k)) {
                total_cnt += hmap.get(running_sum-k);
            }
            hmap.put(running_sum, hmap.getOrDefault(running_sum, 0) + 1);
        }
        return total_cnt;
    }
}
