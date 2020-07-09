package com.shashi.dsalgo.queuedemo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(20);
        queue.add(9);
        queue.add(45);
        queue.add(7);

        System.out.println(queue);
        reverse(queue);
        System.out.println(queue);

    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

}
