package advanced_dsa;
import java.util.*;

class TicTacToe {
    Map<String, Set<Integer>> player1;
    Map<String, Set<Integer>> player2;
    int n;

    public TicTacToe(int n) {
        player1 = new HashMap<>();
        player2 = new HashMap<>();
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        if (player == 1) {
            return process(player1, row, col, player);
        }
        return process(player2, row, col, player);
    }

    private int process(Map<String, Set<Integer>> curMap, int row, int col, int player) {
        Set<Integer> rowSet = curMap.getOrDefault("row: " + row, new HashSet<Integer>());
        rowSet.add(col);
        if (rowSet.size() == n) {
            return player;
        }
        curMap.put("row: " + row, rowSet);
        Set<Integer> colSet = curMap.getOrDefault("col: " + col, new HashSet<Integer>());
        colSet.add(row);
        if (colSet.size() == n) {
            return player;
        }
        curMap.put("col: " + col, colSet);
        if (row == col) {
            Set<Integer> diagonalSet = curMap.getOrDefault("diagonal", new HashSet<Integer>());
            diagonalSet.add(row * n + col);
            if (diagonalSet.size() == n) {
                return player;
            }
            curMap.put("diagonal", diagonalSet);
        }
        if (row + col == n - 1) {
            Set<Integer> antiDiagonalSet = curMap.getOrDefault("anti-diagonal", new HashSet<Integer>());
            antiDiagonalSet.add(row * n + col);
            if (antiDiagonalSet.size() == n) {
                return player;
            }
            curMap.put("anti-diagonal", antiDiagonalSet);
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */