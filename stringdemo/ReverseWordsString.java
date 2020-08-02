package com.shashi.dsalgo.stringdemo;

import java.util.Stack;

public class ReverseWordsString {

    public static void reverseWords(String s) {
        s = s + ".";
        String[] stringArray = s.split("[, ?.@]+");
        String newString = "";

        for (int i = stringArray.length - 1; i >= 0; i--) {
            newString += stringArray[i] + " ";
        }

        newString = newString.substring(0, newString.length() - 1);
        System.out.println(newString);
    }

    public static void main(String[] args) {
        reverseWords("lmao.am.i.noob");
    }
}
