package common;

import java.util.*;

/**
 * Represent a directed graph
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) {
        this.label = x;
        this.neighbors = new ArrayList<DirectedGraphNode>(); 
    }
}