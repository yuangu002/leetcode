package search;

import java.util.*;
import common.TreeNode;

/**
 * Input: root = [3,9,20,null,null,15,7]
    Output: [[9],[3,15],[20],[7]]
    Explanation:
    Column -1: Only node 9 is in this column.
    Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
    Column 1: Only node 20 is in this column.
    Column 2: Only node 7 is in this column.
*/

public class VerticalOrderTraversal {
    TreeMap<Integer, PriorityQueue<NodePosition>> col2Nodes = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0);
        for (int column: col2Nodes.keySet()) {
            PriorityQueue<NodePosition> nodesInColumn = col2Nodes.get(column);
            List<Integer> listOfNodesInCol = new ArrayList<>();
            while (!nodesInColumn.isEmpty()) {
                NodePosition node = nodesInColumn.poll();
                listOfNodesInCol.add(node.val);
            }
            res.add(listOfNodesInCol);
        }
        return res;
    }

    private void dfs(TreeNode node, int row, int col) {
        if (node == null) {
            return;
        }
        NodePosition nodePosition = new NodePosition(node.val, row);
        PriorityQueue<NodePosition> nodesInCol = col2Nodes.getOrDefault(col, new PriorityQueue<NodePosition>(new Comparator<NodePosition>() {
            @Override
            public int compare(NodePosition pos1, NodePosition pos2) {
                if (pos1.row < pos2.row) {
                    return -1;
                } else if (pos1.row > pos2.row) {
                    return 1;
                } else {
                    // sort by value
                    return pos1.val - pos2.val;
                }
            }
        }));
        nodesInCol.offer(nodePosition);
        col2Nodes.put(col, nodesInCol);
        
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}

class NodePosition {
    int val;
    int row;
    public NodePosition(int val, int row) {
        this.val = val;
        this.row = row;
    }
}