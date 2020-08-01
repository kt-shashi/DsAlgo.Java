package com.shashi.dsalgo.stringdemo;

//Sample Input:
//2
//Abcdefghijklmnopqrstuvwxy
//Abc
//Sample Output:
//z
//defghijklmnopqrstuvwxyz

public class MissingCharactersInPanagram {

    public static String missingPanagram(String str) {
        str = str.toLowerCase();

        String result = "";
        int[] count = new int[26];

        for (char ch : str.toCharArray()) {
            if (ch == ' ')
                continue;
            count[ch - 97]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                result += (char) (i + 97);
        }

        return result;
    }

    public static void main(String[] args) {
//        String str = "Abcdefghijklmnopqrstuvwxy";
        String str = "Abc";
        System.out.println("output:  " +
                missingPanagram(str));
    }
}

