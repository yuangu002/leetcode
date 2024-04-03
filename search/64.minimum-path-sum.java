package search;

import java.util.*;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start
class Solution {
    int[][] cache;
    public int minPathSum(int[][] grid) {
        cache = new int[grid.length][grid[0].length];
        for (int i = 0; i < cache.length; ++i) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(0, 0, grid);
    }

    private int dfs(int x, int y, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        if (!isValid(x, y, m, n)) {
            return Integer.MAX_VALUE;
        }
        if (cache[x][y] != -1) {
            return cache[x][y];
        }
        if (x == m - 1 && y == n - 1) {
            cache[x][y] = grid[x][y];
            return grid[x][y];
        }
        int ans = grid[x][y] + Math.min(dfs(x + 1, y, grid), dfs(x, y + 1, grid));
        cache[x][y] = ans;
        return ans;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

    public int minPathSumDp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] cache = new int[m][n];
        cache[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            cache[i][0] = cache[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            cache[0][j] = cache[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                cache[i][j] = Math.min(cache[i-1][j], cache[i][j-1]) + grid[i][j];
            }
        }
        return cache[m-1][n-1];
    }
}
// @lc code=end

