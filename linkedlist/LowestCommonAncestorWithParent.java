package linkedlist;

import java.util.*;
import common.TreeNode;

/**
 * // TODO(solve this): https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

    Each node will have a reference to its parent node. The definition for Node is below:

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes 
    p and q in a tree T is the lowest node that has both p and q as descendants
    (where we allow a node to be a descendant of itself)."
 */
class LowestCommonAncestorWithParent {
    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        Set<TreeNode> path2Root = new HashSet<>();
        TreeNode curNode = p;
        while (curNode != null) {
            path2Root.add(curNode);
            curNode = curNode.parent;
        }

        curNode = q;
        while (curNode != null) {
            if (path2Root.contains(curNode)) {
                return curNode;
            }
            curNode = curNode.parent;
        }
        return null;
    }

    public TreeNode lowestCommonAncestorConstantSpace(TreeNode p, TreeNode q) {
        TreeNode p1 = p;
        TreeNode p2 = q;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = q;
            } else {
                p1 = p1.parent;
            }
            if (p2 == null) {
                p2 = p;
            } else {
                p2 = p2.parent;
            }
        }
        return p1;
    }
}
