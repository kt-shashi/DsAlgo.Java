package com.shashi.dsalgo.linkedlist;

//Given a singly linked list of size N.
// The task is to swap elements in the linked list pairwise.
//For example, if the input list is 1 2 3 4,
// the resulting list after swaps will be 2 1 4 3.

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class PairwiseSwap {

    public Node pairwiseSwap(Node head) {
        // code here
        if (head == null)
            return null;

        Node temp = head;
        while (temp != null) {

            if (temp.next == null)
                return head;
            int tempData = temp.data;
            temp.data = temp.next.data;
            temp.next.data = tempData;
            temp = temp.next.next;
        }

        return head;
    }

}