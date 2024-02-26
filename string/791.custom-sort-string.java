package string;

/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 */

// @lc code=start
class Solution {
    public String customSortString(String order, String s) {
        int[] char2Cnt = new int[26];
        StringBuffer sb = new StringBuffer();
        for (char c: s.toCharArray()) {
            char2Cnt[c - 'a']++;
        }
        for (char orderChar: order.toCharArray()) {
            if (char2Cnt[orderChar - 'a'] == 0) {
                continue;
            }
            while (char2Cnt[orderChar - 'a'] > 0) {
                sb.append(orderChar);
                char2Cnt[orderChar - 'a']--;
            }
        }
        for (int i = 0; i < char2Cnt.length; ++i) {
            while (char2Cnt[i] > 0) {
                sb.append((char)(i + 'a'));
                char2Cnt[i]--;
            }
        }
        return sb.toString(); 
    }
}
// @lc code=end

