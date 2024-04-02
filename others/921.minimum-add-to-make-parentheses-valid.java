package others;

/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String s) {
        int unmatchedLeft = 0;
        int unmatchedRight = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                ++unmatchedLeft;
            } else {
                if (unmatchedLeft == 0) {
                    ++unmatchedRight;
                } else {
                    --unmatchedLeft;
                }
            }
        }
        return unmatchedLeft + unmatchedRight;
    }
}
// @lc code=end

