package com.shashi.dsalgo.stackdemo;

//Algorithm to Convert an Infix expression to Postfix:

//Scan the infix expression from left to right.
//If the scanned character is an operand, output it.
//Else,
//If the precedence of the scanned operator is greater than the precedence of the operator
//in the stack(or the stack is empty or the stack contains a '(' ), push it.

//Else, Pop all the operators from the stack which are greater than or equal to in precedence
//than that of the scanned operator. After doing that Push the scanned operator to the stack.
//(If you encounter parenthesis while popping then stop there and push the scanned operator in the stack.)

//If the scanned character is an ‘(‘, push it to the stack.
//If the scanned character is an ‘)’, pop the stack and and output it until a ‘(‘ is encountered,
//and discard both the parenthesis.

//Repeat steps 2-6 until infix expression is scanned.
//Print the output.
//Pop and output from the stack until it is not empty.


import java.util.Stack;

public class InfixToPostfix {

    //utility function that returns the precedence of operators
    private static int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    //method that converts infix to postfix
    public static String infixToPostfix(String expression) {

        //result array
        String result = new String("");

        Stack<Character> characterStack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            //Case1: If the char is operand, add it to result
            if (Character.isLetterOrDigit(ch))
                result += ch;

                //Case2: If the char is an '(' , push it to stack
            else if (ch == '(')
                characterStack.push(ch);

                //Case3: If the char is ')' , pop until an '(' is encountered
            else if (ch == ')') {

                while (!characterStack.isEmpty() && characterStack.peek() != '(') {
                    result += characterStack.pop();
                }

                if (!characterStack.isEmpty() && characterStack.peek() != '(')
                    return "Invalid Statement";
                else
                    characterStack.pop();   //pop the remaining '('
            }

            //Case5: If an operator is encountered, Pop all the operators
            //from the stack which are greater than or equal to in precedence
            else {
                while (!characterStack.isEmpty() && getPrecedence(ch) <= getPrecedence(characterStack.peek()))
                    result += characterStack.pop();

                characterStack.push(ch);      //push the curernt operator in the stack
            }
        }

        //Pop all remaining operators
        while (!characterStack.isEmpty())
            result += characterStack.pop();

        return result;
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }

}
