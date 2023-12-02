package tree;
import java.util.*;

public class ConstructFromPreAndIn {
    HashMap<Integer, Integer> value2idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        value2idx = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            value2idx.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = value2idx.get(preorder[preStart]);
        root.left = build(preorder, inorder, preStart + 1, inStart, idx - 1);
        root.right = build(preorder, inorder, preStart + idx - inStart + 1, idx + 1, inEnd);
        return root;
    }
}
