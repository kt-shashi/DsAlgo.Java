package com.shashi.dsalgo.stackdemo;

public class TwoStackUsingOneArray {

    private static int[] array;
    private static int size;
    private static int top1, top2;

    TwoStackUsingOneArray(int size) {
        array = new int[size];
        this.size = size;
        top1 = -1;
        top2 = size;
    }

    public static void push1(int data) {

        //If there is at least one empty spot, then push
        if (top1 < top2 - 1) {
            array[++top1] = data;
        } else {
            System.out.println("Stack overflow");
            return;
        }
    }

    public static void push2(int data) {

        //If there is at least one empty spot, then push
        if (top1 < top2 - 1) {
            array[--top2] = data;
        } else {
            System.out.println("Stack overflow");
            return;
        }
    }

    public static int pop1() {
        if (top1 < 0) {
            System.out.println("Stack underflow");
            return -1;
        }

        return array[top1--];
    }

    public static int pop2() {
        if (top2 == size) {
            System.out.println("Stack underflow");
            return -1;
        }

        return array[top2++];
    }

    public static void main(String[] args) {
        TwoStackUsingOneArray ts = new TwoStackUsingOneArray(5);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from" +
                " stack1 is " + ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from" +
                " stack2 is " + ts.pop2());
    }

}
