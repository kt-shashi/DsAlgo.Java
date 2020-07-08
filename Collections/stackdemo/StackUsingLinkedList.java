package com.shashi.dsalgo.stackdemo;

public class StackUsingLinkedList {

    static class StackNode {
        int data;
        StackNode next;

        StackNode(int data) {
            this.data = data;
        }
    }

    StackNode root;

    public boolean isEmpty() {
        return root == null;
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);

        if (root == null)
            root = newNode;
        else {
            newNode.next = root;
            root = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int poppedValue = root.data;
            root = root.next;
            return poppedValue;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return root.data;
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return;
        }

        StackNode temp = root;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
