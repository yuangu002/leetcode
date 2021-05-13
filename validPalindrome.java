
public class ValidPalindrome {
    
    // Character.isLetter()
    // Character.toLowerCase()
    // Character.isDigit()
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null) return false;
        if (s.length() == 0) return true;
        
        int left = 0, right = s.length() - 1;
        while (left < right){
            // Find valid character
            while (left < right && !isValidChar(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValidChar(s.charAt(right))) {
                right--;
            }
            
            // get lower case
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            
            if (left < right && leftChar != rightChar) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    private boolean isValidChar(char c) {
        if (c >= 'a' && c <= 'z'){
            return true;
        } else if (c >= 'A' && c <= 'Z') {
            return true;
        } else if (c >= '0' && c <= '9'){
            return true;
        }
        
        return false;
    }

}