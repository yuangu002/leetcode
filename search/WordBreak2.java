package search;

import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence
    where each word is a valid dictionary word. Return all such possible sentences in any order.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.

    Example 1:

    Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    Output: ["cats and dog","cat sand dog"]
    Example 2:

    Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
    Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
    Explanation: Note that you are allowed to reuse a dictionary word.
    Example 3:

    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: []
 */
class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<String>(wordDict), new HashMap<String, List<String>>());
    }
    
    private List<String> dfs(String s, Set<String> dict, HashMap<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("200-OK");
            return res;
        }
        for (String word: dict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), dict, memo);
                for (String substr: subList) {
                    if (substr.equals("200-OK")) {
                        res.add(word);
                        continue;
                    }
                    res.add(word + " " + substr);
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
