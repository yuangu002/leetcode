
/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
* */

import java.util.ArrayList;
import java.util.*;

public class lengthOfLongestSubstring {

    /*
    This is a O(n^3) solution: for every character in the string,
    find the longest non-repeated substring start from it. Maintain the largest length
    */
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            if (s == null || length == 0) return 0;
            int result=1;
            int eachLength;
            int startIndex = 0;
            ArrayList<Character> seen = new ArrayList<Character>();
            while (startIndex < length){
                eachLength = 0;
                seen.clear();
                for (int i = startIndex; i < length; i++){
                    if (isRepeated(s.charAt(i), seen)) break;
                    eachLength++;
                    seen.add(s.charAt(i));
                }
                if (eachLength > result) result = eachLength;
                startIndex++;
            }
            return result;
        }

        private boolean isRepeated(char s, ArrayList<Character> seen){
            for (int i = 0; i < seen.size(); i++) {
                if (seen.get(i)==s) return true;
            }
            return false;
        }
    }

    /*
    * This is O(n) solution based on dynamic programming:
    * Maintain an array which stores each character's distance with its last appearance.
    * Maintain two lengths: current length and max length
    * Traverse the string:
    * If the character is totally new or the distance is larger than current length being maintained,
    * increment the current length by 1;
    * Otherwise, update the max length, and also set the current length to distance; (这一步很重要, consider: "prwewkewab")
    * Update the position array where the character appears
    * */
    class Solution2 {
        public int lengthOfLongestSubstring(String s){
            if (s == null || s.length() == 0) return 0;
            int[] arr = new int[128];
            int curLength=0, maxLength=0;
            for (int j = 0; j < 128; j++) arr[j] = -1;
            for (int i = 0; i < s.length(); i++){
                int pos = s.charAt(i);
                int preAppear = arr[pos];
                int dist = i-preAppear;
                if (preAppear == -1 || dist > curLength) curLength++;
                else {
                    if (curLength > maxLength) maxLength = curLength;
                    curLength = dist;
                }
                arr[pos]=i;
            }
            if (curLength > maxLength) maxLength = curLength;
            return maxLength;
        }
    }

    /**
     * This is a O(N) solution based on two pointers.
     * Maintain a left and right point. Advance both while making sure no repeated characters
     */
    class Solution3 {
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
}
