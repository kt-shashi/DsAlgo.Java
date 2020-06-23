package com.shashi.dsalgo;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {

        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        queue.offer("d");

        System.out.println(queue.peek());      //Returns item at the front

        //removes and returns first item in the queue
        //throws exception if queue is empty
        queue.remove();

        //removes and returns first item in the queue
        //Returns null if queue is empty
        queue.poll();

        System.out.println(queue);

    }

}
