package com.shashi.dsalgo.treedemo;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Tree intTree=new Tree();

        //insert into Tree
//        intTree.insert(25);
//        intTree.insert(20);
//        intTree.insert(15);
//        intTree.insert(27);
//        intTree.insert(30);
//        intTree.insert(29);
//        intTree.insert(26);
//        intTree.insert(22);
//        intTree.insert(32);
//        intTree.insert(17);

        intTree.insert(20);
        intTree.insert(10);
        intTree.insert(15);
        intTree.insert(12);
        intTree.insert(30);
        intTree.insert(25);
        intTree.insert(45);
        intTree.insert(40);

        intTree.traverseInOrder();

//        //get a node using value
//        System.out.println(intTree.get(27));
//        System.out.println(intTree.get(17));
//        System.out.println(intTree.get(8888));

//        System.out.println("Max: "+intTree.max());
//        System.out.println("Min: "+intTree.min());


//        System.out.println("Delete a node: 15 ");
//        intTree.delete(27);
//
//        intTree.traverseInOrder();

//        System.out.println("level order");
//        intTree.traverseLevelOrder();

        System.out.println("Iterative");
        intTree.traverseInOrderIterative();
    }
}
