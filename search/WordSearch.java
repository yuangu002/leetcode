package search;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 */

public class WordSearch {
    
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (dfs(i, j, board, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int x,
                        int y,
                        char[][] board,
                        char[] word,
                        int cur_len) {
        if (cur_len == word.length) {
            return true;
        }
        
        if (!canGo(x, y, board)) {
            return false;
        }
        
        if (word[cur_len] != board[x][y]) {
            return false;
        }
        
        char tmp = board[x][y];
        board[x][y] = '0';
        boolean flag = dfs(x + 1, y, board, word, cur_len + 1)
                        || dfs(x, y + 1, board, word, cur_len + 1)
                        || dfs(x - 1, y, board, word, cur_len + 1)
                        || dfs(x, y - 1, board, word, cur_len + 1);
        board[x][y] = tmp;
        return flag;
    }
    
    
    private boolean canGo(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (board[x][y] == '0') {
            return false;
        }
        return true;
    }
}
