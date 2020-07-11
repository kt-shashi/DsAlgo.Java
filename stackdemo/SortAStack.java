package com.shashi.dsalgo.stackdemo;

import java.util.Stack;

//sortStack(): First pop all stack items and store the popped item
//in function call stack using recursion. And when stack becomes empty,
//push new item and all items stored in call stack

//sortedInsert(): If the top of stack is smaller, then push the element
//If top is greater, remove the top item (-> temp) , and recursively try adding the elment
//Put back the top item (temp) removed earlier

public class SortAStack {

    public static Stack<Integer> sort(Stack<Integer> s) {
        sortStack(s);
        return s;
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int temp = stack.pop();
        sortStack(stack);

        sortedInsert(stack, temp);
    }

    public static void sortedInsert(Stack<Integer> stack, int element) {

        if (stack.isEmpty() || stack.peek() < element) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        sortedInsert(stack, element);

        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(45);
        stack.push(25);
        stack.push(78);
        stack.push(1);
        stack.push(-5);

        stack = sort(stack);
        System.out.println(stack);
    }
}


