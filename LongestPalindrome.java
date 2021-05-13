
public class LongestPalindrome {

    public int longestPalindromeBuilt(String s) {
        // write your code here
        if (s == null || s.length() == 0) return 0;
        
        int[] count = new int[52];
        int odd = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                count[c - 'A' + 26]++;
            } else {
                count[c - 'a']++;
            }
        }
        
        for (int i = 0; i < count.length; ++i) {
            if (count[i] % 2 == 1) {
                ++odd;
            }
        }
        
        if (odd <= 1) return s.length();
        return s.length() - odd + 1;
    }
}
