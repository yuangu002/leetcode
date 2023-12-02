package pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // sort the array
            qsort(nums, 0, nums.length-1);
            List<List<Integer>> res = new ArrayList<>();

            // [-2, -1, 0, 1, 2, 2]
            // fix one pointer, and do two sum for the rest
            for (int i = 0; i < nums.length; i++){
                // remove duplicates
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1, k = nums.length - 1;
                while (j < k){
                    if (nums[i]+nums[j]+nums[k] == 0){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        j++;
                        k--;

                        // remove duplicates
                        while (j < k && nums[j] == nums[j - 1]) {
                            ++j;
                        }
                    }
                    else if (nums[i]+nums[j]+nums[k] < 0) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
            return res;
        }

        // quick sort
        private void qsort(int[] nums, int low, int high){
            if (low < high){
                int p = partition(nums, low, high);
                qsort(nums, 0, p-1);
                qsort(nums, p+1, high);
            }
        }

        private int partition(int[] nums, int low, int high){
            int pivot = nums[high];
            int pos = low-1;
            for (int i = low; i < high; i++){
                if (nums[i] <= pivot) {
                    pos++;
                    int temp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = temp;
                }
            }
            int temp = nums[pos+1];
            nums[pos+1] = nums[high];
            nums[high] = temp;
            return pos+1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        
        List<List<Integer>> res = solution.threeSum(new int[]{-2, -1, 0, 0, 2, 2});
        for (int i = 0; i < res.size(); ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.println(res.get(i).get(j));
            }
            System.out.println("****");
        }
    }
}
