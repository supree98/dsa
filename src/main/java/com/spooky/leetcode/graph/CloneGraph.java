package com.spooky.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        Node newNode = cloneGraph(node, visited);
        return newNode;
    }

    private Node cloneGraph(Node node, Map<Node, Node> visited) {
        if (node == null) {
            return null;
        }

        // if the node is already created, there is already a clone for that node
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // create a new node and add the neighbors to it by cloning the nodes from original
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(node, newNode);

        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            Node newNeighbor = cloneGraph(neighbor, visited);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }

}
