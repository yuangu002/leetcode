package search;

/**
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

    Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
import java.util.*;

public class LetterCombinations {

    private static final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinationsBFS(String digits) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        q.offer("");
        while (!q.isEmpty()) {
            String curStr = q.poll();
            
            if (curStr.length() == digits.length()) {
                res.add(curStr);
                continue;
            }
            // determine the current digit and mapped characters
            int curDigit = digits.charAt(curStr.length()) - '0';
            for (char c: MAPPING[curDigit].toCharArray()) {
                String newStr = curStr + c;
                q.offer(newStr);
            }
        }
        return res;
    }

    public List<String> letterCombinationsDFS(String digits) {
        List<String> res = new ArrayList<>();
        dfs(digits, "", res);
        return res;
    }

    private void dfs(String digits, String curStr, List<String> res) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        int curDigit = digits.charAt(curStr.length()) - '0';
        for (char c: MAPPING[curDigit].toCharArray()) {
            dfs(digits, curStr + c, res);
        }
    }
}
