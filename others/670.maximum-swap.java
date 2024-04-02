package others;

import java.util.Arrays;

/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 */

// @lc code=start
class Solution {
    // 27376
    // 77326
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        char[] numChars = numStr.toCharArray();
        int[] num2Idx = new int[10];
        Arrays.fill(num2Idx, -1);
        for (int i = 0; i < numChars.length; ++i) {
            num2Idx[numChars[i] - '0'] = i;
        }

        for (int j = 0; j < numChars.length; ++j) {
            for (int k = 9; k >= 0; --k) {
                int idx = num2Idx[k];
                if (idx == -1) {
                    continue;
                }
                // swap idx and j
                if (k > numChars[j] - '0' && idx > j) {
                    char tmp = numChars[j];
                    numChars[j] = numChars[idx];
                    numChars[idx] = tmp;
                    String newStr = new String(numChars);
                    return Integer.valueOf(newStr);
                }
            }
        }
        return num;
    }
}
// @lc code=end

