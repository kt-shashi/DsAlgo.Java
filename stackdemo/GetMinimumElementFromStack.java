package com.shashi.dsalgo.stackdemo;

//You are given N elements and your task is to Implement a Stack
//in which you can get minimum element in O(1) time.

import java.util.Stack;

public class GetMinimumElementFromStack {

    int minEle;
    Stack<Integer> s;

    GetMinimumElementFromStack() {
        s = new Stack<>();
    }

    int getMin() {
        if (s.isEmpty())
            return -1;
        return minEle;
    }

    //If stack is empty, return -1
    //Case 1: If top element > minElement
    //then simply pop
    //Case 2: If top element (stack.peek()) < minElement
    //*If we have an element less than the minElement, then it is our flag value*
    //We used the formula -> 2 * element - MinElement to store X
    //Now we use formula ->  2 * minElement - stack.peek() , to get previous minElement
    //now pop stack.peek()
    int pop() {
        if (s.isEmpty())
            return -1;

        int top = s.pop();
        if (top < minEle) {
            int popedElement = minEle;
            minEle = 2 * minEle - top;
            return popedElement;
        } else
            return top;
    }


    //If the stack is empty, then push the element, and minElement = element
    //Otherwise we have 2 cases
    //Case 1: Element is greater than minElement
    //In this case, push the element into stack
    //Case 2: Element is less than minElement
    //In this case, push -> 2 * element - minElement
    //Store the element in minElement
    //Here, we are storing the actual element in minElement, and a flag value in stack
    void push(int x) {
        if (s.isEmpty()) {
            s.push(x);
            minEle = x;
            return;
        }

        if (x < minEle) {
            s.push(2 * x - minEle);
            minEle = x;
        } else {
            s.push(x);
        }
    }

    public static void main(String[] args) {
        GetMinimumElementFromStack stack = new GetMinimumElementFromStack();
        stack.push(6);
        stack.push(3);
        stack.push(5);
        stack.push(2);

        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }

}
