import java.util.*;

public class WordSeach2 {
    int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (board == null || words == null) {
            return res;
        }
        Trie trie = new Trie();
        for (String str: words) {
            trie.insert(str);
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(board, i, j, res, trie.root);
            }
        }
        
        return res;
    }
    
    private void dfs(char[][] board,
                    int i,
                    int j,
                    List<String> res,
                    TrieNode node) {
        if (!node.children.containsKey(board[i][j])) {
            return;
        }
    
        TrieNode cur = node.children.get(board[i][j]);
        if (cur.isWord() && !res.contains(cur.word)) {
            res.add(new String(cur.word));
        }

        
        char tmp = board[i][j];
        board[i][j] = '0';
        for (int k = 0; k < 4; ++k) {
            int new_x = i + DIRECTIONS[k][0];
            int new_y = j + DIRECTIONS[k][1];
            if (!isValid(new_x, new_y, board)) {
                continue;
            }
            dfs(board, new_x, new_y, res, cur);
        }
        board[i][j] = tmp;
    }

    private boolean isValid(int x, int y, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (x >= m || x < 0 || y >= n || y < 0) {
            return false;
        }
        return board[x][y] != '0';
    }
}

class Trie {
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}

class TrieNode {
    String word;
    HashMap<Character, TrieNode> children;
    
    public TrieNode() {
        word = null;
        children = new HashMap<>();
    }
    
    public boolean isWord() {
        return word != null;
    }
}
