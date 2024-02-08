package tree;
import java.util.*;
import common.TreeNode;

public class ConstructFromInAndPost {
    HashMap<Integer, Integer> val2idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        val2idx = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            val2idx.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd || postEnd < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIdx = val2idx.get(root.val);
        
        root.left = build(inorder, postorder, inStart, rootIdx - 1, postEnd - inEnd + rootIdx - 1);
        root.right = build(inorder, postorder, rootIdx + 1, inEnd, postEnd - 1);
        return root;
    }
}
