package common;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
