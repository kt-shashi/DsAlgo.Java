package com.shashi.dsalgo.undirectedgraph;

import java.util.*;

public class WeightedGraph {

    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();      //Variable to store Nodes

    public void addNode(String label) {

        Node node = new Node(label);        //Wrap the Node
        nodes.putIfAbsent(label, node);     //Store the Node

    }

    public void addEdge(String from, String to, int weight) {

        //Wrap the Nodes
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        //Check if not present
        if (fromNode == null || toNode == null) {
            throw new IllegalArgumentException();
        }

        //Add the edge in the list of specified Node for Undirected Graph
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);

    }

    public void print() {

        for (Node node : nodes.values()) {
            List<Edge> edges = node.getEdges();
            if (!edges.isEmpty()) {
                System.out.println("Connections of " + node + ": " + edges);
            }
        }

    }

    public boolean hasCycle() {

        Set<Node> visited = new HashSet<>();

        for (Node node : nodes.values()) {
            if (!visited.contains(node) && hasCycle(node, null, visited)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {

        visited.add(node);

        for (Edge edge : node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to)) {
                return true;
            }

            if (hasCycle(edge.to, node, visited)) {
                return true;
            }
        }

        return false;
    }

}
