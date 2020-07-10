package com.shashi.dsalgo.stackdemo;

import java.util.Stack;

public class ReverseAString {

    public static void main(String[] args) {

        System.out.println(reverseString("random"));
        System.out.println(reverseString(null));
        System.out.println(reverseString("a"));

    }

    private static String reverseString(String inputString) {

        if (inputString == null)
            return "";
        if (inputString.length() == 1)
            return inputString;

        Stack<Character> stack = new Stack<>();
        char[] charArray = inputString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);
        }

        StringBuffer outputString = new StringBuffer();
        while (!stack.isEmpty()) {
            outputString.append(stack.pop());
        }

        return outputString.toString();
    }

}
