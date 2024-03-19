package search;
import java.util.*;

/**
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle).
 * You can move up, down, left, or right from and to an empty cell in one step.
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1)
 * given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 */
class ShortestPathWithObstacleElimination {
    private static int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int s = 0; s < sz; ++s) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                int curK = cur[2];
                if (curX == m - 1 && curY == n - 1) {
                    return step;
                }
                for (int i = 0; i < DIR.length; ++i) {
                    int nextX = curX + DIR[i][0];
                    int nextY = curY + DIR[i][1];
                    int nextK = curK;
                    if (!canGo(nextX, nextY, m, n, nextK, visited)) {
                        continue;
                    }
                    if (grid[nextX][nextY] == 1) {
                        ++nextK;
                    }
                    // use out of obstacle eliminations
                    if (nextK > k) {
                        continue;
                    }
                    if (!visited[nextX][nextY][nextK]) {
                        q.offer(new int[]{nextX, nextY, nextK});
                        visited[nextX][nextY][nextK] = true;
                    }
                }
            }
            ++step;
        }
        return -1;
    }

    private boolean canGo(int x, int y, int m, int n, int k, boolean[][][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return !visited[x][y][k];
    }
}
