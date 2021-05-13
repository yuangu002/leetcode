public class LongestPalindromicSubstrings {
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length()<=1) return s;
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int[] max = new int[2];
            for (int i = length; i > -1; i--){
                for (int j =i+1; j < length; j++){
                    // base case: 1 or 2
                    if (j - i <= 2){
                        if (s.charAt(i)==s.charAt(j)) {
                            dp[i][j]=true;
                            if (j-i+1 > max[1]-max[0]+1){
                                max[0]=i;
                                max[1]=j;
                            }
                        }
                    }
                    else {
                        if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true) {
                            dp[i][j]=true;
                            if (j-i+1 > max[1]-max[0]+1){
                                max[0]=i;
                                max[1]=j;
                            }
                        }
                    }
                }
            }
            return s.substring(max[0], max[1]+1);
        }
    }
}