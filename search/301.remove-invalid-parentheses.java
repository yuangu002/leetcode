package search;

import java.util.*;

/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        boolean done = false;
        q.offer(s);
        visited.add(s);
        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; ++i) {
                String curString = q.poll();
                // check if valid
                if (isValid(curString)) {
                    done = true;
                    res.add(curString);
                }
                for (int k = 0; k < curString.length(); ++k) {
                    char c = curString.charAt(k);
                    if (c != '(' && c != ')') {
                        continue;
                    }
                    String nextStr = curString.substring(0, k) + curString.substring(k + 1);
                    if (visited.contains(nextStr)) {
                        continue;
                    }
                    q.offer(nextStr);
                    visited.add(nextStr);
                }
            }
            if (done) {
                return res;
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
}
// @lc code=end

