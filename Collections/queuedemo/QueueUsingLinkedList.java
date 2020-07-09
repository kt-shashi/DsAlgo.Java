package com.shashi.dsalgo.queuedemo;

class QueueNode {
    int data;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
    }
}

public class QueueUsingLinkedList {
    QueueNode front, rear;

    public void enqueue(int data) {

        QueueNode newNode = new QueueNode(data);

        if (rear == null) {
            rear = newNode;
            front = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

    }

    public int dequeue() {
        if (isEmpty())
            return -1;

        int deletedData = front.data;
        front = front.next;

        return deletedData;
    }

    public int peek() {
        if (isEmpty())
            return -1;

        return front.data;
    }

    private boolean isEmpty() {
        return front == null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }

        System.out.println();
        QueueNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        QueueUsingLinkedList myQueue = new QueueUsingLinkedList();

        myQueue.enqueue(10);
        myQueue.enqueue(50);
        myQueue.enqueue(60);
        myQueue.enqueue(70);
        myQueue.enqueue(30);
        myQueue.enqueue(90);

        myQueue.printQueue();

        while (!myQueue.isEmpty()) {
            System.out.println("Dequeue: " + myQueue.dequeue());
            myQueue.printQueue();
        }

    }

}
