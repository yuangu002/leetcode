package pointers;

/**
 * Determine whether a string is a palindrome by allowing only one mismatch
 * 
 * racecar -> true
 * wmillim
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValid(s, left+1, right) || isValid(s, left, right-1);
            }
            ++left;
            --right;
        }
        return true;
    }
    
    private boolean isValid(String s, int start, int end) {
        int left = start, right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
