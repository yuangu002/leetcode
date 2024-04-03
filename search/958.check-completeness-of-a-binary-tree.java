package search;

import java.util.*;
import common.TreeNode;

/*
 * @lc app=leetcode id=958 lang=java
 *
 * [958] Check Completeness of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<NodeIndex> q = new LinkedList<>();
        q.offer(new NodeIndex(root, 1));
        int lastIndex = 0;

        while (!q.isEmpty()) {
            NodeIndex curNode = q.poll();
            TreeNode node = curNode.node;
            int index = curNode.index;
            if (lastIndex + 1 != index) {
                return false;
            }
            lastIndex = index;
            if (node.left != null) {
                NodeIndex leftNode = new NodeIndex(node.left, index * 2);
                q.offer(leftNode);
            }
            if (node.right != null) {
                NodeIndex rightNode = new NodeIndex(node.right, index * 2 + 1);
                q.offer(rightNode);
            }
        }
        return true;
    }
}

class NodeIndex {
    TreeNode node;
    int index;
    public NodeIndex(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
// @lc code=end

