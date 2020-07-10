package com.shashi.dsalgo.queuedemo;

public class QueueUsingArray {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = -1;
    }

    public boolean isFull() {
        return rear == queue.length - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void enqueue(int data) {
        if (isFull())
            return;

        if (front == -1)
            front = 0;

        queue[++rear] = data;
    }

    public int dequeue() {
        if (isEmpty())
            return -1;

        return queue[front++];
    }

    public int peek() {
        if (isEmpty())
            return -1;

        return queue[front];
    }

    public void printQueue() {
        if (isEmpty())
            return;

        for (int i = front; i <= rear; i++)
            System.out.print(queue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingArray myQueue = new QueueUsingArray(5);
        myQueue.enqueue(20);
        myQueue.enqueue(45);
        myQueue.enqueue(76);
        myQueue.enqueue(3);
        myQueue.enqueue(1);

        myQueue.printQueue();
        System.out.println(myQueue.dequeue());
        myQueue.printQueue();
    }

}
