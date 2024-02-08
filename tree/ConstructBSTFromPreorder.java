package tree;
import java.util.*;
import common.TreeNode;

public class ConstructBSTFromPreorder {
    HashMap<Integer, Integer> val2idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        val2idx = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            val2idx.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, 0, preorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int preStart, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = val2idx.get(root.val);
        root.left = build(preorder, inorder, preStart + 1, start, idx - 1);
        root.right = build(preorder, inorder, preStart + idx - start + 1, idx + 1, end);
        return root;
    }
}
