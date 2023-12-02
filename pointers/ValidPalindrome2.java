package pointers;

/**
 * Determine whether a string is a palindrome by allowing only one mismatch
 * 
 * racecar -> true
 * wmillim
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        // Write your code here
        if (s == null) return false;
        if (s.length() == 0) return true;
        
        int[] pair = findFirstMismatch(s);
        // The string is a palindrome 
        if (pair == null) {
            return true;
        }
        int left = pair[0];
        int right = pair[1];
        
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        
    }
    
    private int[] findFirstMismatch(String s){
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return new int[]{start, end};
            }
            start++;
            end--;
        }
        return null;
    }

    /**
     * Ulitity func to determine if a string is a palindrome
     * @param s string
     * @param start start ptr
     * @param end end ptr
     * @return
     */
    private boolean isPalindrome(String s, int start, int end){
        while (start < end && s.charAt(start) == s.charAt(end)){
            start++;
            end--;
        }
        return (start >= end);
    }

}
