package com.shashi.dsalgo.stringdemo;
//Given two strings a and b consisting of
// lowercase characters. The task is to check
// whether two given strings are an anagram of
// each other or not. An anagram of a string is
// another string that contains the same characters,
// only the order of characters can be different.

// For example, “act” and “tac” are an anagram of each other.
//Example 1:
//Input:
//a = geeksforgeeks, b = forgeeksgeeks
//Output: YES

public class Anagram {

    public static boolean isAnagram(String s1, String s2) {
        int[] compare = new int[26];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 0; i < c1.length; i++)
            compare[c1[i] - 97]++;
        for (int i = 0; i < c2.length; i++)
            compare[c2[i] - 97]--;

        boolean flag = true;
        for (int i = 0; i < compare.length; i++)
            if (compare[i] != 0) {
                flag = false;
                break;
            }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("lmmao", "noob"));
    }

}
