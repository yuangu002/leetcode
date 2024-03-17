package search;

/*
 * @lc app=leetcode id=528 lang=java
 * 
 * [2,5,3,4] -> [2,7,10,14]
 *
 * [528] Random Pick with Weight
 */

// @lc code=start

import java.util.Random;

class Solution {
    int[] wSum;
    int max;
    public Solution(int[] w) {
        wSum = new int[w.length];
        wSum[0] = w[0];
        for (int i = 1; i < w.length; ++i) {
            wSum[i] = wSum[i-1] + w[i];
        }
        max = wSum[wSum.length - 1];
    }
    
    public int pickIndex() {
        int idx = new Random().nextInt(max) + 1;
        // find the first number large or equal than idx
        int start = 0, end = wSum.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (wSum[mid] >= idx) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (wSum[start] >= idx) {
            return start;
        } else {
            return end;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

