package graph;

import java.util.*;
import common.DirectedGraphNode;

public class TopSort {

    public List<Integer> topologicalSort(Map<Integer, DirectedGraphNode> graph) {
        //queue里是当前indegree为0的节点
        Queue<Integer> q = new LinkedList<>();
        for (int label: graph.keySet()) {
            DirectedGraphNode node = graph.get(label);
            if (node.indegree == 0) {
                q.offer(label);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            res.add(cur);
            DirectedGraphNode curNode = graph.get(cur);
            for (Integer neighbor: curNode.neighbors) {
                DirectedGraphNode neighborNode = graph.get(neighbor);
                neighborNode.indegree--;
                graph.put(neighbor, neighborNode);
                if (neighborNode.indegree == 0) {
                    q.offer(neighbor);
                }
            }
        }
        if (res.size() != graph.size()) {
            return null;
        }
        return res;
    }
}
