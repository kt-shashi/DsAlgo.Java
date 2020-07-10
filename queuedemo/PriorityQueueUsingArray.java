package com.shashi.dsalgo.queuedemo;

public class PriorityQueueUsingArray {

    private int[] priorityQueue;
    private int count;

    public PriorityQueueUsingArray(int capacity) {
        priorityQueue = new int[capacity];
    }

    private boolean isFull() {
        return count == priorityQueue.length;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int data) {

        if (isFull())
            return;

        int i;
        for (i = count - 1; i >= 0; i--) {
            if (priorityQueue[i] > data)
                priorityQueue[i + 1] = priorityQueue[i];
            else break;
        }
        priorityQueue[i + 1] = data;
        count++;

    }

    public int dequeue() {
        if (isEmpty())
            return -1;

        return priorityQueue[--count];
    }

    public void printQueue() {
        if (isEmpty())
            System.out.println("Empty");

        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print(priorityQueue[i] + " ");
        }
    }

    public static void main(String[] args) {
        PriorityQueueUsingArray myQueue = new PriorityQueueUsingArray(5);
        myQueue.enqueue(20);
        myQueue.printQueue();
        myQueue.enqueue(2);
        myQueue.printQueue();
        myQueue.enqueue(230);
        myQueue.printQueue();
        myQueue.enqueue(30);
        myQueue.printQueue();
        myQueue.enqueue(0);
        myQueue.printQueue();
        myQueue.enqueue(1);
        myQueue.printQueue();

        System.out.println();
        while (!myQueue.isEmpty()) {
            System.out.print("\nDequeue: " + myQueue.dequeue());
            myQueue.printQueue();
        }
    }
}
