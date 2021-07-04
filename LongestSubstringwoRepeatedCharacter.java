import java.util.*;

public class LongestSubstringwoRepeatedCharacter {
    
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, ans = 0;
        
        while (left < s.length() && left <= right) {
            while (right < s.length() && !seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                ++right;
            }
            ans = Math.max(ans, right - left);
            char removedChar = s.charAt(left);
            left++;
            seen.remove(removedChar);
        }
        return ans;
    }
}
