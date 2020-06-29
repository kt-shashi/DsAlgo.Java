package com.shashi.dsalgo.greedyproblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


//Make a min heap with all Characters
//Allocate a new node
//z.left=Extract-min()
//Z.right=extract-min()
//Z.Freq=x.freq+y.freq
//Insert Z in queue

//Structure of HuffmanTree
class HuffmanNode {
    public int data;        //Count of each char
    public char c;          //char

    public HuffmanNode leftChild;
    public HuffmanNode rightChild;
}

// comparator class helps to compare the node
// on the basis of one of its attribute.
// Here we will be comparing
// on the basis of data values of the nodes (Count)
class MyComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        return o1.data - o2.data;
    }
}

public class HuffmanCoding {

    //Main Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //number of char
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        //Creating PriorityQueue to make Min Heap
        //N is size of queue, MyComparator is how it will be stored in Queue
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(n, new MyComparator());

        for (int i = 0; i < n; i++) {

            //creating a Huffman node and adding to PriorityQueue
            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.c = charArray[i];
            huffmanNode.data = charFreq[i];

            huffmanNode.leftChild = null;
            huffmanNode.rightChild = null;

            //add the node to Queue
            queue.add(huffmanNode);
        }

        //create a root node
        HuffmanNode root = null;

        //Extract the two minimum value
        //from the heap each time until
        //its size reduces to 1
        //extract until all the nodes are extracted.
        while (queue.size() > 1) {

            //Extract first minimun
            HuffmanNode node1 = queue.peek();
            queue.poll();

            //Extract second minimun
            HuffmanNode node2 = queue.peek();
            queue.poll();

            //New Node to add the first and second Min nodes
            HuffmanNode newNode = new HuffmanNode();
            newNode.data = node1.data + node2.data;
            newNode.c = '-';

            //first extracted node is set as left child
            newNode.leftChild = node1;

            //second extracted node is set as right child
            newNode.rightChild = node2;

            //Making newNode as the root Node
            root = newNode;

            //Add the node to the PriorityQueue
            queue.add(root);

        }

        //print code
        printHuffmanCode(root, "");

    }

    //Recursive algo to print the huffmanTree
    public static void printHuffmanCode(HuffmanNode root, String s) {

        if (root.leftChild == null &&
                root.rightChild == null &&
                Character.isLetter(root.c)) {
            //C is the character of the node
            System.out.println(root.c + " : " + s);
            return;
        }

        //If we go left, then Add "0" to the code
        //If we go right, then Add "1" to the code

        //recursive call for left and right sub-tree
        printHuffmanCode(root.leftChild, s + "0");
        printHuffmanCode(root.rightChild, s + "1");
    }
}