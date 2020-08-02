package com.shashi.dsalgo.stringdemo;

//Input:

//geeksforgeeks
//forgeeksgeeks

//mightandmagic
//andmagicmigth

//mushroomkingdom
//itsamemario

//geekofgeeks
//geeksgeekof

//Output:
//1
//0
//0
//1

//Approach:
//If lengths of given string are not same, return false
//Loop till the length of 1st string
//Remove the first letter of the 1st string, and add it to the last index
//Compare if it is equal to the 2nd string ort not

public class CheckStringsAreRotated {

    public static boolean areRotations(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            String newString = "" + s1.charAt(0);
            s1 = s1.substring(1);
            s1 = s1 + newString;
            if (s1.compareTo(s2) == 0)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(areRotations("geeksforgeeks", "forgeeksgeeks"));
    }

}
