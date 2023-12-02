package search;
import java.util.*;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        back(ans, n, "", 0, 0);
        return ans;
    }
    
    private void back(List<String> ans, int max, String cur, int open, int close){
        if (cur.length() == 2 * max){
            ans.add(cur);
            return;
        } else {
            if (open < max) back(ans, max, cur + "(", open + 1, close);
            if (close < open) back(ans, max, cur + ")", open, close + 1);
        }
    }
}
