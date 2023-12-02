package pointers;

/**
 * Example 1:

    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
 */

public class LongestPalindromicSubstrings {

    /**
     * DP solution
     */
    public String longestPalindromeDynamicProgramming(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int[] max = new int[2];
        for (int i = length; i > -1; i--) {
            for (int j = i + 1; j < length; j++){
                // base case: 1 or 2
                if (j - i <= 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (j - i + 1 > max[1] - max[0] + 1){
                            max[0] = i;
                            max[1] = j;
                        }
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        if (j - i + 1 > max[1] - max[0] + 1){
                            max[0] = i;
                            max[1] = j;
                        }
                    }
                }
            }
        }
        return s.substring(max[0], max[1] + 1);
    }

    /**
     * Two pointers solution
     */
    public String longestPalindromeTwoPointers(String s) {
        int maxStart = 0;
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            int len = expandFrom(s, i, i);
            int start = i - (len / 2);
            if (len > maxLen) {
                maxLen = len;
                maxStart = start;
            }
        }
        
        for (int i = 0; i < s.length() - 1; ++i) {
            int left = i, right = i + 1;
            int len = expandFrom(s, left, right);
            int start = right - (len / 2);
            if (len > maxLen) {
                maxLen = len;
                maxStart = start;
            }
        }
        
        return s.substring(maxStart, maxStart + maxLen);
    }
    
    private int expandFrom(String s, int left, int right) {
        int start = left, end = right;
        
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                return end - start - 1;
            }
            --start;
            ++end;
        }
        return end - start - 1;
    }
}