import java.util.List;

import common.TreeNode;
import search.VerticalOrderTraversal;

public class Test {

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.left = left;
        root.right = right;
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.right.left = rightLeft;
        root.right.right = rightRight;
        VerticalOrderTraversal solution = new VerticalOrderTraversal();
        List<List<Integer>> res = solution.verticalTraversal(root);
        for (List<Integer> list: res) {
            System.out.println("start of list: ");
            for (int val: list) {
                System.out.println(val);
            }
        }
    }
}