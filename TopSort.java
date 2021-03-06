import java.util.*;

public class TopSort {

    public ArrayList<DirectedGraphNode> topologicalSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return graph;
        }
        // 储存节点的indegree数量
        Map<DirectedGraphNode, Integer> hmap = new HashMap<>();
        for (DirectedGraphNode node: graph) {
            for (DirectedGraphNode neighbor: node.neighbors) {
                hmap.put(neighbor, hmap.getOrDefault(neighbor, 0) + 1);
            }
        }
        //queue里是当前indegree为0的节点
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for (DirectedGraphNode node: graph) {
            if (!hmap.containsKey(node)) {
                q.offer(node);
            }
        }
        
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        
        while (!q.isEmpty()) {
            DirectedGraphNode cur = q.poll();
            res.add(cur);
            for (DirectedGraphNode neighbor: cur.neighbors) {
                int cnt = hmap.get(neighbor);
                cnt--;
                if (cnt == 0) {
                    q.offer(neighbor);
                }
                hmap.put(neighbor, cnt);
            }
        }
        return res;
    }

}

/**
 * Represent a directed graph
 */
class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>(); 
    }
};
