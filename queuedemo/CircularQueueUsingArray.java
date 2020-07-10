package com.shashi.dsalgo.queuedemo;

public class CircularQueueUsingArray {

    private int[] circularQueue;
    private int front;
    private int rear;
    private int currentQueueSize;

    public CircularQueueUsingArray(int capacity) {
        circularQueue = new int[capacity];
        front = rear = -1;
        currentQueueSize = 0;
    }

    public boolean isFull() {
        return currentQueueSize == circularQueue.length;
    }

    public boolean isEmpty() {
        return currentQueueSize == 0;
    }

    public void enqueue(int data) {
        if (isFull())
            return;

        if (front == -1)
            front = 0;

        rear = (rear + 1) % circularQueue.length;
        circularQueue[rear] = data;
        currentQueueSize++;
    }

    public int dequeue() {
        if (isEmpty())
            return -1;

        int deletedItem = circularQueue[front];
        circularQueue[front] = 0;
        front = (front + 1) % circularQueue.length;
        currentQueueSize--;

        return deletedItem;
    }

    public int peek() {
        if (isEmpty())
            return -1;

        return circularQueue[front];
    }

    public void printQueue() {
        if (isEmpty())
            return;

        System.out.println("Print Queue: ");
        for (int i = 0; i < circularQueue.length; i++)
            System.out.print(circularQueue[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueueUsingArray myQueue = new CircularQueueUsingArray(5);
        myQueue.enqueue(20);
        myQueue.enqueue(45);
        myQueue.enqueue(76);
        myQueue.enqueue(3);
        myQueue.enqueue(1);
        myQueue.enqueue(11);

        myQueue.printQueue();

        for (int i = 0; i < 3; i++) {
            System.out.println("Peek" + (i + 1) + " : " + myQueue.dequeue());
            myQueue.printQueue();
        }

        for (int i = 10; i <= 60; i += 10) {
            System.out.println("Enqueue: " + (i * 2));
            myQueue.enqueue(i * 2);
            myQueue.printQueue();
        }

    }

}
