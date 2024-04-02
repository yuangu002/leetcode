package search;

import java.util.*;

/*
 * @lc app=leetcode id=827 lang=java
 *
 * [827] Making A Large Island
 */

// @lc code=start
class Solution {
    private static int[][] DIR = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> areaMap = new HashMap<>();
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int index = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 1) {
                    continue;
                }
                ++index;
                int area = bfs(i, j, grid, index);
                areaMap.put(index, area);
                ans = Math.max(ans, area);
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> seenIndex = new HashSet<>();
                    for (int k = 0; k < 4; ++k) {
                        int nextI = i + DIR[k][0];
                        int nextJ = j + DIR[k][1];

                        if (hasConnectedIsland(nextI, nextJ, grid.length, grid[0].length, grid)
                                && !seenIndex.contains(grid[nextI][nextJ])) {
                            int idx = grid[nextI][nextJ];
                            area += areaMap.get(idx);
                            seenIndex.add(idx);
                        }
                        ans = Math.max(ans, area);
                    }
                }
            }
        }
        return ans;
    }

    private int bfs(int startX, int startY, int[][] grid, int index) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { startX, startY });
        grid[startX][startY] = index;
        int ans = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0], curY = cur[1];
            ++ans;
            for (int k = 0; k < 4; ++k) {
                int nextX = curX + DIR[k][0];
                int nextY = curY + DIR[k][1];
                if (!isIsland(nextX, nextY, grid.length, grid[0].length, grid)) {
                    continue;
                }
                q.offer(new int[] { nextX, nextY });
                grid[nextX][nextY] = index;
            }
        }
        return ans;
    }

    private boolean isIsland(int x, int y, int m, int n, int[][] grid) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return grid[x][y] == 1;
    }

    private boolean hasConnectedIsland(int x, int y, int m, int n, int[][] grid) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return grid[x][y] > 1;
    }
}
// @lc code=end
