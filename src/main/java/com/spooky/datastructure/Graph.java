package com.spooky.datastructure;

import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class Graph {

    private static class Node {
        private final String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();

    private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void add(String label) {
        if (nodes.containsKey(label)) {
            return;
        }
        Node newNode = new Node(label);
        nodes.put(label, newNode);
        adjacencyList.put(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        if (!nodes.containsKey(from) || !nodes.containsKey(to)) {
            throw new IllegalArgumentException();
        }
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        adjacencyList.get(fromNode).add(toNode);
    }

    public void depthFirst(String label) {
        depthFirst(nodes.get(label), new HashSet<>());
    }

    private void depthFirst(Node node, Set<Node> visited) {
        if (node == null) {
            return;
        }
        System.out.print(node.label + ", ");
        visited.add(node);
        List<Node> adjacencyNodes = adjacencyList.get(node);
        for (Node adjacencyNode : adjacencyNodes) {
            if (!visited.contains(adjacencyNode)) {
                depthFirst(adjacencyNode, visited);
            }
        }
    }

    public void depthFirstIterative(String label) {
        if (!nodes.containsKey(label)) {
            return;
        }
        Node root = nodes.get(label);
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Set<Node> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (visited.contains(node)) {
                continue;
            }
            System.out.print(node.label + ", ");
            visited.add(node);

            for (Node adjacencyNode : adjacencyList.get(node)) {
                if (!visited.contains(adjacencyNode)) {
                    stack.push(adjacencyNode);
                }
            }
        }
    }

    public void breadthFirst(String label) {
        Node root = nodes.get(label);
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited.contains(node)) {
                continue;
            }
            System.out.print(node.label + ", ");
            visited.add(node);
            for (Node adjacencyNode : adjacencyList.get(node)) {
                if (!visited.contains(adjacencyNode)) {
                    queue.offer(adjacencyNode);
                }
            }
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : nodes.values()) {
            topologicalSort(node, stack, visited);
        }
        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty()) {
            sorted.add(stack.pop().label);
        }
        return sorted;
    }

    public void topologicalSort(Node root, Stack<Node> stack, Set<Node> visited) {
        if (visited.contains(root)) {
            return;
        }
        visited.add(root);
        for (Node adjacencyNode : adjacencyList.get(root)) {
            topologicalSort(adjacencyNode, stack, visited);
        }
        stack.push(root);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>(nodes.values());
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node node = all.iterator().next();
            if (hasCycle(node, all, visiting, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        if (visited.contains(node)) {
            return false;
        }
        all.remove(node);
        visiting.add(node);

        for (Node neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour)) {
                continue;
            }
            if (visiting.contains(neighbour)) {
                return true;
            }
            if (hasCycle(neighbour, all, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

    public void print() {
        for (Map.Entry<Node, List<Node>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey().label + " is connected to " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        var graph = new Graph();
//        graph.add("A");
//        graph.add("B");
//        graph.add("C");
//        graph.add("D");
//        graph.add("E");
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "E");
//        graph.addEdge("B", "E");
//        graph.addEdge("C", "A");
//        graph.addEdge("C", "B");
//        graph.addEdge("C", "D");
//        graph.addEdge("D", "E");

//        graph.print();
//        graph.depthFirst("C");
//        System.out.println();
//        graph.depthFirstIterative("C");
//        graph.breadthFirst("E");

        // Topological sort
//        graph.add("X");
//        graph.add("A");
//        graph.add("B");
//        graph.add("P");
//        graph.addEdge("X", "A");
//        graph.addEdge("X", "B");
//        graph.addEdge("A", "P");
//        graph.addEdge("B", "P");
//        System.out.println(graph.topologicalSort());

        // Cycle detection
        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        System.out.println(graph.hasCycle());
    }
}
