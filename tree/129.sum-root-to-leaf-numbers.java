package tree;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

// @lc code=start

import common.TreeNode;

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
    int globalSum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return globalSum;
    }

    private void dfs(TreeNode node, int pathSum) {
        if (node == null) {
            return;
        }
        pathSum = pathSum * 10 + node.val;
        if (isLeaf(node)) {
            globalSum += pathSum;
            return;
        }
        dfs(node.left, pathSum);
        dfs(node.right, pathSum);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
// @lc code=end

