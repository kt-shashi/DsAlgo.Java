package com.shashi.dsalgo.directedgraph;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Graph graph=new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A","B");
        graph.addEdge("B","C");
        graph.addEdge("C","A");

//        graph.traverseBreadthFirst("A");

        System.out.println(graph.hasCycle());

    }
}
