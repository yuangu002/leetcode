package search;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
  ]
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<Integer>();
        backtrack (res, curList, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> curList, int[] nums){
        if (curList.size() == nums.length){
            res.add(new ArrayList<>(curList));
        }else{
            for (int i = 0; i<nums.length; ++i){
                if (!curList.contains(nums[i])){
                    curList.add(nums[i]);
                    backtrack(res, curList, nums);
                    curList.remove(curList.size()-1);
                }
            }
        }
    }
}