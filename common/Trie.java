package common;

import java.util.*;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.

    Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curNode = root;
        for (char c: word.toCharArray()) {
            if (curNode.children.containsKey(c)) {
                curNode = curNode.children.get(c);
            } else {
                curNode.children.put(c, new TrieNode());
                curNode = curNode.children.get(c);
            }
        }
        curNode.isWord = true;
    }

    boolean search(String word) {
        TrieNode curNode = root;
        for (char c: word.toCharArray()) {
            if (!curNode.children.containsKey(c)) {
                return false;
            } else {
                curNode = curNode.children.get(c);
            }
        }
        return curNode.isWord;
    }

    boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (char c: prefix.toCharArray()) {
            if (!curNode.children.containsKey(c)) {
                return false;
            } else {
                curNode = curNode.children.get(c);
            }
        }
        return true;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
}
