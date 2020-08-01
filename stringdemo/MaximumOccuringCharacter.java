package com.shashi.dsalgo.stringdemo;

//Given a string str. The task is to find
// the maximum occurring character in the
// string str. If more than one character
// occurs the maximum number of time then
// print the lexicographically smaller character.

import java.util.HashMap;

public class MaximumOccuringCharacter {
    public static char getMaxOccuringChar(String line) {
        int[] count = new int[26];

        for (char ch : line.toCharArray()) {
            if (ch == ' ')
                continue;
            count[ch - 97]++;
        }

        char largest = '0';
        int countLarget = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > countLarget && ((char) (i + 97)) > largest) {
                countLarget = count[i];
                largest = (char) (i + 97);
            }
        }

        return largest;
    }

    public static void main(String[] args) {
//        String str = "sample string";
        String str = "lmao nooba";
        System.out.println("Max occurring character is " +
                getMaxOccuringChar(str));
    }

}
