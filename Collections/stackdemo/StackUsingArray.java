package com.shashi.dsalgo.stackdemo;

public class StackUsingArray {

    public int[] stack;
    public int top;
    private int capacity;

    public StackUsingArray(int n) {
        stack = new int[n];
        top = -1;
        capacity = n;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top - 1 == capacity;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top];
    }

    public void printData() {
        System.out.println("Print Stack");
        for (int i = 0; i <= top; i++)
            System.out.print(stack[i] + " ");
        System.out.println();
    }

}


