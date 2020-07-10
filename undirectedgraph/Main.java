package com.shashi.dsalgo.undirectedgraph;

public class Main {

    public static void main(String[] args) {
        // write your code here

        WeightedGraph graph = new WeightedGraph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 2);
        graph.addEdge("C", "A", 2);

//        graph.print();
        System.out.println(graph.hasCycle());
    }
}
