package search;

/**
 * DoorDash phone screen
 * Maximum number of orders by one dasher
 * - Can only continue if the next order's time is later than the current time.
 */
class MaximumStackedOrder {
    public int maximumStackedOrder(int[][] grid) {
        int answer = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                answer = Math.max(answer, dfs(grid, i, j, m, n, 0));
            }
        }
        return answer;
    }

    private int dfs(int[][] grid, int x, int y, int m, int n, int prevTime) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }
        if (grid[x][y] <= prevTime) {
            return 0;
        }
        int maxLeftRight = Math.max(dfs(grid, x + 1, y, m, n, grid[x][y]), dfs(grid, x - 1, y, m, n, grid[x][y]));
        int maxTopDown = Math.max(dfs(grid, x, y + 1, m, n, grid[x][y]), dfs(grid, x, y - 1, m, n, grid[x][y]));
        return 1 + Math.max(maxLeftRight, maxTopDown); 
    }
}
