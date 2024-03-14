package tree;
import common.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
    p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
class LowestCommonAncestor {
    // for this question, we assume the TreeNode doesn't have the `parent` property
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
        if (leftLca != null && rightLca != null) {
            return root;
        } else if (leftLca != null) {
            return leftLca;
        } else if (rightLca != null) {
            return rightLca;
        }
        return null;
    }
}
