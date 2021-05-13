import java.util.*;

public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] numbers, int target) {
            // write your code here
            Arrays.sort(numbers);
            List<List<Integer>> res = new ArrayList<>();
            if (numbers == null || numbers.length < 4) {
                return res;
            }
            
            for (int i = 0; i < numbers.length - 3; ++i) {
                if (i > 0 && numbers[i] == numbers[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < numbers.length - 2; ++j) {
                    if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                        continue;
                    }
                    int left = j + 1, right = numbers.length - 1, newtarget = target - (numbers[i] + numbers[j]);
                    while (left < right) {
                        if (numbers[left] + numbers[right] == newtarget) {
                            ArrayList<Integer> quadruplets = new ArrayList<>();
                            quadruplets.add(numbers[i]);
                            quadruplets.add(numbers[j]);
                            quadruplets.add(numbers[left]);
                            quadruplets.add(numbers[right]);
                            res.add(quadruplets);
                            ++left;
                            --right;
                            while (left < right && numbers[left] == numbers[left - 1]){
                                ++left;
                            }
                            while (left < right && numbers[right] == numbers[right + 1]) {
                                --right;
                            }
                        } else if (numbers[left] + numbers[right] < newtarget) {
                            ++left;
                        } else {
                            --right;
                        }
                    }
                }
            }
            return res;
        }
    }
}
