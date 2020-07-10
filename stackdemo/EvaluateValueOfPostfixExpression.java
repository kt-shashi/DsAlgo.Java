package com.shashi.dsalgo.stackdemo;

//Algo

//Create a stack to store operands (or values).

//Scan the given expression and do following for every scanned element.
//  If the element is a number, push it into the stack.
//  If the element is an operator, pop 2 operands for the operator from the stack.
//  Evaluate the operator and push the result back to the stack.

//When the expression is ended, the number in the stack is the final answer.

import java.util.Stack;

public class EvaluateValueOfPostfixExpression {

    // Method to evaluate value of a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> operandStack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            //If character is operand, push into stack
            if (Character.isDigit(ch))
                operandStack.push(ch - '0');

                //if character is operator, pop 2 items, perform the operation and push back to stack
            else {
                int operand1 = operandStack.pop();
                int operand2 = operandStack.pop();

                switch (ch) {
                    case '+':
                        operandStack.push(operand2 + operand1);
                        break;
                    case '-':
                        operandStack.push(operand2 - operand1);
                        break;
                    case '/':
                        operandStack.push(operand2 / operand1);
                        break;
                    case '*':
                        operandStack.push(operand2 * operand1);
                        break;
                }
            }
        }

        return operandStack.pop();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
//        String exp = "231*+9-";
        String exp = "93/25-+";
        System.out.println("Postfix evaluation: " + evaluatePostfix(exp));
    }

}
