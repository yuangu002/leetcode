package pointers;

import java.util.HashMap;

public class TwoSum {
    class Solution1{
        public int[] twoSum(int[] nums, int target){
            for (int i = 0; i < nums.length; i++){
                for (int j = i+1; j < nums.length; j++){
                    if (nums[i]+nums[j]==target) return new int[]{i,j};
                }
            }
            return new int[2];
        }
    }

    class Solution2{
        public int[] twoSum(int[] nums, int target){
            HashMap<Integer, Integer> hmap = new HashMap<>();
            for (int i = 0; i < nums.length; i++){
                if (!hmap.containsKey(nums[i])) hmap.put(target-nums[i], i);
                else return new int[]{hmap.get(nums[i]),i};
            }
            return new int[2];
        }
    }
}
