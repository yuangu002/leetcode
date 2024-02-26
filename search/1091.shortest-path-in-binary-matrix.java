package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    static int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0][0] != 0) {
            return -1;
        }
        int step = 1;
        int n = grid.length;
        // a coordinate (x, y) can be represented as (y * n + x)
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int s = 0; s < sz; ++s) {
                int current = q.poll();
                int curX = current % n;
                int curY = current / n;
                if (curX == n - 1 && curY == n - 1) {
                    return step;
                }
                for (int i = 0; i < DIR.length; ++i) {
                    int nextX = curX + DIR[i][0];
                    int nextY = curY + DIR[i][1];
                    if (!canGo(nextX, nextY, n, grid, visited)) {
                        continue;
                    }
                    q.offer(nextY * n + nextX);
                    visited.add(nextY * n + nextX);
                }
            }
            step++;
        }
        return -1;
    }

    private boolean canGo(int x, int y, int n, int[][] grid, HashSet<Integer> visited) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        return !visited.contains(y * n + x) && grid[x][y] == 0;
    }
}
// @lc code=end

