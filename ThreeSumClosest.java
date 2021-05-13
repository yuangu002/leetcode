import java.util.Arrays;

public class ThreeSumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int diff = Integer.MAX_VALUE;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length-1; i++){
                int j = i+1, k = nums.length-1;
                while (j < k){
                    int sum = nums[i]+nums[j]+nums[k];
                    if (sum == target) return sum;
                    else if (sum > target){
                        if (sum - target < diff) {
                            diff = sum-target;
                            res = sum;
                        }
                        k--;
                    }else{
                        if (target - sum < diff) {
                            diff = target-sum;
                            res = sum;
                        }
                        j++;
                    }
                }
            }
            return res;
        }
    }
}
