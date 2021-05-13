import java.util.LinkedList;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

public class LetterCombinations {
    class Solution {
        public List<String> letterCombinations(String digits) {
            LinkedList<String> res = new LinkedList<>();
            if (digits.length() == 0 || digits == null) return res;
            final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            res.addLast("");
            while (res.peekFirst().length() < digits.length()){
                String alter = res.removeFirst();
                String mapstr = map[digits.charAt(alter.length())-'0'];
                for (int i = 0; i < mapstr.length(); i++) res.addLast(alter+mapstr.charAt(i));
            }
            return res;
        }
    }
}
