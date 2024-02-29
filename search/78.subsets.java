package search;
import java.util.*;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    /**
     * BFS solution that traverses level-by-level.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(-1, new ArrayList<>()));

        while (!q.isEmpty()) {
            Node node = q.poll();
            List<Integer> curList = node.list;
            res.add(curList);
            for (int i = node.idx + 1; i < nums.length; ++i) {
                curList.add(nums[i]);
                q.offer(new Node(i, new ArrayList<>(curList)));
                curList.remove(curList.size() - 1);
            }
        }
        return res;
    }

    /**
     * same solution by DFS.
     * Leaf nodes are traversed first.
     */
    public List<List<Integer>> subsetsDfs(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        s.push(new Node(-1, new ArrayList<>()));

        while (!s.isEmpty()) {
            Node node = s.pop();
            List<Integer> curList = node.list;
            res.add(curList);

            for (int i = node.idx + 1; i < nums.length; ++i) {
                curList.add(nums[i]);
                s.push(new Node(i, new ArrayList<>(curList)));
                curList.remove(curList.size() - 1);
            }
        }
        return res;
    }
}

class Node {
    int idx;
    List<Integer> list;
    public Node(int idx, List<Integer> list) {
        this.idx = idx;
        this.list = list;
    }
}
// @lc code=end
