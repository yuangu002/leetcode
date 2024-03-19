package common;

import java.util.*;

/**
 * Represent a directed graph
 */
public class DirectedGraphNode {
    public int indegree;
    public ArrayList<Integer> neighbors;
    public DirectedGraphNode() {
        this.neighbors = new ArrayList<Integer>();
        this.indegree = 0;
    }
}