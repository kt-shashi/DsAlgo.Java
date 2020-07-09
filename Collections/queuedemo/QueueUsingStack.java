package com.shashi.dsalgo.queuedemo;

import java.util.Stack;

//Use stack 1 for enqueue operation
//Use stack 2 for dequeue op
//Push data in stack 2 only if stack 2 is empty

public class QueueUsingStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int data) {
        stack1.push(data);
    }

    public int dequeue() {
        if (isEmpty())
            return -1;

        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.pop();
    }

    public int peek() {
        if (isEmpty())
            return -1;

        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.peek();
    }

    private boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack newQueue = new QueueUsingStack();
        newQueue.enqueue(10);
        newQueue.enqueue(20);
        newQueue.enqueue(30);

        System.out.println(newQueue.dequeue());
        System.out.println(newQueue.dequeue());
        System.out.println(newQueue.dequeue());
        System.out.println(newQueue.dequeue());
        System.out.println(newQueue.peek());

    }

}
