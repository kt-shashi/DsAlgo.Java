package com.shashi.dsalgo;

import com.shashi.dsalgo.linkedlistdemo.LinkedListDemo;
import com.shashi.dsalgo.stackdemo.StackUsingLinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here

        LinkedListDemo myLinkedList = new LinkedListDemo();
        myLinkedList.insert(20);
        myLinkedList.insert(40);
        myLinkedList.insert(53);
        myLinkedList.insert(70);
        myLinkedList.insert(5);
        myLinkedList.insert(81);

        myLinkedList.printLinkedList();

        myLinkedList.deleteByPosition(3);

        myLinkedList.printLinkedList();

    }
}
