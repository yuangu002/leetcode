package tree;
import java.util.Stack;

public class BSTiterator {
    public Stack<TreeNode> stack = new Stack<>();
    /*
    * @param root: The root of binary tree.
    */public BSTiterator(TreeNode root) {
        // do intialization if necessary
        findMostLeft(root);
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode node = stack.pop();
        if (node.right != null) {
            findMostLeft(node.right);
        }
        return node;
    }

    private void findMostLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}