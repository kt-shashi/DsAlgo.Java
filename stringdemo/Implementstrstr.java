package com.shashi.dsalgo.stringdemo;

//Your task is to implement the function
// strstr. The function takes two strings
// as arguments (s,x) and  locates the occurrence
// of the string x in the string s. The function
// returns and integer denoting the first
// occurrence of the string x in s (0 based indexing).

//input

//GeeksForGeeks
//Fr
//GeeksForGeeks
//For

//Output
//-1
//5

//Approach:
//Start i from 0 and j from 0
//If string1[i to j] is equal to string2[i to j]
//then j==string2.length()
//return i in this case

public class Implementstrstr {

    public static int strstr(String str, String target) {
        if (str == null || target == null)
            return -1;

        for (int i = 0; i < str.length() + 1 - target.length(); i++) {
            int j;
            for (j = 0; j < target.length() && j < str.length(); j++) {
                if (str.charAt(i + j) == target.charAt(j)) {
                    continue;
                } else break;
            }

            if (j == target.length())
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
//        String str = "Abcdefghijklmnopqrstuvwxy";

        String str = "lmao noob";
        String str2 = "noob";

        System.out.println("output:  " +
                strstr(str, str2));
    }
}
