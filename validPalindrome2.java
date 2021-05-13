
public class validPalindrome2 {

    public boolean validPalindrome(String s) {
        // Write your code here
        if (s == null) return false;
        if (s.length() == 0) return true;
        
        int[] pair = findFirstMismatch(s);
        if (pair == null) return true;
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
    
    private boolean isPalindrome(String s, int start, int end){
        while (start < end && s.charAt(start) == s.charAt(end)){
            start++;
            end--;
        }
        return (start >= end);
    }

}