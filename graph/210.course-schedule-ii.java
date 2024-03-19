package graph;
import java.util.*;

import common.DirectedGraphNode;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        DirectedGraphNode[] graph = buildGraph(numCourses, prerequisites);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            DirectedGraphNode node = graph[i];
            if (node.indegree == 0) {
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            DirectedGraphNode curNode = graph[course];
            ans[idx++] = course;
            for (int nextCourse: curNode.neighbors) {
                DirectedGraphNode nextNode = graph[nextCourse];
                nextNode.indegree--;
                if (nextNode.indegree == 0) {
                    q.offer(nextCourse);
                }
            }
        }
        // Haven't finished all courses but cannot find a eligible course to take
        if (idx != numCourses) {
            return new int[]{};
        }
        return ans;
    }

    private DirectedGraphNode[] buildGraph(int num, int[][] prerequisites) {
        DirectedGraphNode[] graph = new DirectedGraphNode[num];
        for (int i = 0; i < graph.length; ++i) {
            graph[i] = new DirectedGraphNode();
        }
        for (int[] prerequisite: prerequisites) {
            int from = prerequisite[1], to = prerequisite[0];
            DirectedGraphNode fromNode = graph[from];
            DirectedGraphNode toNode = graph[to];
            fromNode.neighbors.add(to);
            toNode.indegree++;
        }
        return graph;
    }
}
// @lc code=end

