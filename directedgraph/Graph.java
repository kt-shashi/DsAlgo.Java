package com.shashi.dsalgo.directedgraph;

import java.util.*;

public class Graph {

    private class Node{
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }


    }

    private Map<String,Node> nodes=new HashMap<>();             //to store Nodes
    private Map<Node, List<Node>> adjacencyList=new HashMap<>();

    public void addNode(String label){

        //Wrap the Node
        Node node=new Node(label);

        //Store the Node
        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(String from, String to){

        //Wrap the Nodes
        Node fromNode=nodes.get(from);
        Node toNode=nodes.get(to);

        //Check if not present
        if(fromNode==null){
            throw new IllegalArgumentException();
        }
        if(toNode==null){
            throw new IllegalArgumentException();
        }

        //Add the edge in the list of specified Node
        adjacencyList.get(fromNode).add(toNode);

    }

    public void print(){

        for(Node source: adjacencyList.keySet()){
            List<Node> targets=adjacencyList.get(source);
            if(!targets.isEmpty()){
                System.out.println(source+" is connected to "+targets);
            }
        }
    }

    public void removeNode(String label){

        //Store the Node to be Deleted
        Node node=nodes.get(label);

        //Check if not present
        if(node==null){
            return;
        }

        //remove links of Node to be deleted from other Node's list
        for(Node n: adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        //Delete the node
        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to){

        //Store the Node to be Deleted
        Node fromNode=nodes.get(from);
        Node toNode=nodes.get(to);

        //Check if not present
        if(fromNode==null || toNode==null)
            return;

        //Delete the edge from the list of SourceNode
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseBreadthFirst(String root){
        Node node=nodes.get(root);
        if(node==null)
            return;

        Set<Node> visited=new HashSet<>();

        Queue<Node> queue=new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()){
            Node current=queue.remove();

            if (visited.contains(current)){
                continue;
            }

            System.out.println(current);
            visited.add(current);

            for(Node neighbour: adjacencyList.get(current)){
                if(!visited.contains(neighbour))
                    queue.add(neighbour);
            }
        }
    }

    public void traverseDepthFirst(String root){

        Node node=nodes.get(root);
        if(node==null){
            return;
        }

        traverseDepthFirst(node,new HashSet<>());
    }

    private void traverseDepthFirst(Node root,Set<Node> visited){

        System.out.println(root);
        visited.add(root);

        for(Node node:adjacencyList.get(root)){
            if(!visited.contains(node)){
                traverseDepthFirst(node,visited);
            }
        }
    }

    public void traverseDepthFirstIterative(String root){
        Node node=nodes.get(root);
        if(node==null){
            return;
        }
        Set<Node> visited=new HashSet<>();
        Stack<Node> stack=new Stack<>();
        stack.push(node);

        while (!stack.empty()){
            Node current=stack.pop();
            if(visited.contains(current)){
                continue;
            }

            System.out.println(current);
            visited.add(current);

            for(Node neighbour: adjacencyList.get(current)){
                if(!visited.contains(current)){
                    stack.push(neighbour);
                }
            }
        }

    }

    public boolean hasCycle(){
        Set<Node> all=new HashSet<>();
        all.addAll(nodes.values());
        Set<Node> visiting= new HashSet<>();
        Set<Node> visited=new HashSet<>();

        while(!all.isEmpty()){
            Node current=all.iterator().next();
            if(hasCycle(current,all,visiting,visited))
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node,Set<Node> all,Set<Node> visiting,Set<Node> visited){

        //Remove from All and add to visiting
        all.remove(node);
        visiting.add(node);

        //Visit neighbours
        for(Node neighbour: adjacencyList.get(node)){

            //If visited set contains neighbour, then continue
            if (visited.contains(neighbour))
                continue;

            if(visiting.contains(neighbour))
                return true;

            if(hasCycle(neighbour,all,visiting,visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }


}
