package others;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int rev = 0;
        while (y != 0) {
            rev = rev*10 + y%10;
            y /= 10;
        }
        return rev==x;
    }
}
