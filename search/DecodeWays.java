package search;
import java.util.*;

public class DecodeWays {

    public int numDecodings(String s) {
        return dfs(s, 0, new HashMap<Integer, Integer>());
    }
    
    private int dfs(String s, int start, Map<Integer, Integer> index2count) {
        if (index2count.containsKey(start)) {
            return index2count.get(start);
        }
        
        if (start == s.length()) {
            return 1;
        }
        
        int d = s.charAt(start) - '0';
        if (d == 0) {
            return 0;
        }

        int moveOne = dfs(s, start + 1, index2count);
        int moveTwo = 0;
        
        if (d <= 2 && start != s.length()-1) {
            int next = s.charAt(start+1) - '0';
            if (d * 10 + next <= 26) {
                moveTwo = dfs(s, start + 2, index2count);
            }
        }
        
        index2count.put(start, moveOne + moveTwo);
        return moveOne + moveTwo;
    }   
}
