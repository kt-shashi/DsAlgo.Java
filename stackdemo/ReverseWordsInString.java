package com.shashi.dsalgo.stackdemo;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordsInString {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String input = sc.next();
            System.out.println(reverseWords(input));
        }
    }

    public static String reverseWords(String input) {
        Stack<String> stack = new Stack<>();
        String word = "";
        char[] newInput = new char[input.length() + 1];
        for (int i = 0; i < input.length(); i++)
            newInput[i] = input.charAt(i);
        newInput[newInput.length - 1] = '.';

        for (char ch : newInput) {
            if (ch == '.') {
                stack.push(word);
                word = "";
            } else {
                word += ch;
            }
        }

        String reverseDWord = "";
        while (!stack.isEmpty()) {
            reverseDWord += stack.pop() + ".";
        }

        reverseDWord = reverseDWord.substring(0, reverseDWord.length() - 1);
        return reverseDWord;
    }
}
