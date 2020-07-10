package com.shashi.dsalgo.linkedlistdemo;

public class LinkedListDemo {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = null;

        if (root == null) {
            root = newNode;
            return;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public int deleteByKey(int key) {
        if (root == null) {
            System.out.println("No data in Linked List");
            return -1;
        }

        Node current = root;
        Node prev = null;
        int deletedKey = -1;

        //Case 1: Delete the first element
        if (root.data == key) {
            deletedKey = root.data;
            root = root.next;

            return deletedKey;
        }

        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        //Case 2: Key is found
        //Current will not be null if we found the key
        if (current != null) {
            //remove current from the linked list
            prev.next = current.next;

            deletedKey = current.data;
        }

        //Case 3: Key not found
        //Current will be null if we did not find the key
        //i.e. current will travel till the end of the list and finally will be
        //assigned null
        if (current == null) {
            deletedKey = -1;
        }

        return deletedKey;
    }

    public int deleteByPosition(int index) {
        if (root == null) {
            System.out.println("No data in LinkedList");
            return -1;
        }

        int deletedData = -1;

        //case 1:
        //If index=0, remove head
        if (index == 0) {
            root = root.next;
            return deletedData;
        }

        //Case 2:
        //Index greater than length of Linked list
        int length = getLength();
        if (index > length) {
            return deletedData;
        }

        Node current = root;
        Node prev = current;

        //Case 3:
        //Index >0 && less than length
        while (index-- > 0) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        deletedData = current.data;

        return deletedData;

    }

    public int getLength() {
        if (root == null)
            return 0;

        Node temp = root;
        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public void printLinkedList() {
        if (root == null) {
            System.out.println("No data in Linked List");
            return;
        }
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
