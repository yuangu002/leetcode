package search;
import java.util.*;

public class Maze {
    private static int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    /**
     * There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1).
     * The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall.
     * When the ball stops, it could choose the next direction.
     * Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol],
     * return true if the ball can stop at the destination, otherwise return false.
     * You may assume that the borders of the maze are all walls (see examples).
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int startX = start[0], startY = start[1];
        int destX = destination[0], destY = destination[1];
        int m = maze.length, n = maze[0].length;
        // y * m + x = index
        // x = index % m
        // y = index / m
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(startY * m + startX);
        visited.add(startY * m + startX);

        while (!q.isEmpty()) {
            int index = q.poll();
            int curX = index % m;
            int curY = index / m;

            if (curX == destX && curY == destY) {
                return true;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nextX = curX;
                int nextY = curY;
                while (canGo(nextX, nextY, m, n, maze)) {
                    nextX += DIR[i][0];
                    nextY += DIR[i][1];
                }

                // the wall, backtrack one
                nextX -= DIR[i][0];
                nextY -= DIR[i][1];
                int nextIndex = nextY * m + nextX;
                if (visited.contains(nextIndex)) {
                    continue;
                }
                q.offer(nextIndex);
                visited.add(nextIndex);
            }
        }
        return false;
    }

    private boolean canGo(int x, int y, int m, int n, int[][] maze) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return maze[x][y] == 0;
    }
}
