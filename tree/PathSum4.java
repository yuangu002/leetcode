package tree;
import java.util.*;

class PathSum4 {
    int globalSum = 0;
    Map<Integer, Integer> tree = new HashMap<>();
    public int pathSum(int[] nums) {
        for (int num: nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }
        dfs(1, 1, 0);
        return globalSum;
    }

    private void dfs(int d, int p, int curSum) {
        int key = d * 10 + p;
        if (!tree.containsKey(key)) {
            return;
        }
        curSum += tree.get(key);
        int leftKey = (d + 1) * 10 + 2 * p - 1;
        int rightKey = (d + 1) * 10 + 2 * p;
        if (!tree.containsKey(leftKey) && !tree.containsKey(rightKey)) {
            globalSum += curSum;
            return;
        }
        dfs(d + 1, 2 * p - 1, curSum);
        dfs(d + 1, 2 * p, curSum);
    }
}
