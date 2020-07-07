package com.shashi.dsalgo.stackdemo;

import java.util.Stack;

public class BalanceExpressions {

    public static void main(String[] args) {

        boolean result = checkIfBalanced("(1+2)");
        System.out.println(result);
    }

    public static boolean checkIfBalanced(String input) {

        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(' || ch == '<' || ch == '[' || ch == '{')
                stack.push(ch);
            if (ch == ')' || ch == '>' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == '>' && top != '<') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }

        return stack.empty();
    }

}
