package advanced_dsa;

import java.util.*;

/**
 * Design a data structure that simulates an in-memory file system.

    Implement the FileSystem class:

    FileSystem() Initializes the object of the system.
    List<String> ls(String path)
    If path is a file path, returns a list that only contains this file's name.
    If path is a directory path, returns the list of file and directory names in this directory.
    The answer should in lexicographic order.
    void mkdir(String path) Makes a new directory according to the given path.
    The given directory path does not exist. If the middle directories in the path do not exist, you should create them as well.
    void addContentToFile(String filePath, String content)
    If filePath does not exist, creates that file containing given content.
    If filePath already exists, appends the given content to original content.
    String readContentFromFile(String filePath) Returns the content in the file at filePath
 */
class FileSystem {
    TrieNode root;
    public FileSystem() {
        root = new TrieNode("");
    }
    
    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();
        TrieNode node = searchNode(path, false);
        if (node == null) {
            return ans;
        }
        if (node.isFile()) {
            ans.add(node.id);
        } else {
            for (String subPath: node.children.keySet()) {
                ans.add(subPath);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    
    public void mkdir(String path) {
        searchNode(path, true);
    }
    
    public void addContentToFile(String filePath, String content) {
        TrieNode node = searchNode(filePath, true);
        node.addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        TrieNode node = searchNode(filePath, false);
        if (node == null || !node.isFile()) {
            return null;
        }
        return node.getContent();
    }

    private TrieNode searchNode(String path, boolean createIfAbsent) {
        TrieNode cur = root;
        String[] paths = path.split("/");
        for (String dir: paths) {
            if (dir.isEmpty()) {
                continue;
            }
            if (!cur.children.containsKey(dir)) {
                if (!createIfAbsent) {
                    return null;
                }
                cur.children.put(dir, new TrieNode(dir));
            }
            cur = cur.children.get(dir);
        }
        return cur;
    }
}

class TrieNode {
    StringBuffer content;
    String id;
    Map<String, TrieNode> children;

    public TrieNode(String id) {
        this.id = id;
        children = new HashMap<>();
    }

    public boolean isFile() {
        return content != null;
    }

    public String getContent() {
        return content.toString();
    }

    public void addContent(String str) {
        if (content == null) {
            content = new StringBuffer(str);
        } else {
            content.append(str);
        }
    }
}
