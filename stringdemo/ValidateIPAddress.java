package com.shashi.dsalgo.stringdemo;

//4 dots
//0-255

import java.util.Arrays;
import java.util.regex.Pattern;

//Edge cases:
//A dot at the end of the string
//Total no of words = 4
//Total digits in each word, 0<=value<256
//No unnecessary zeros at the starting of the word

public class ValidateIPAddress {

    public static boolean isValidIP(String s) {

        if (s == null || s == "" || s == " ")
            return false;

        if (s.charAt(s.length() - 1) == '.')
            return false;

        s += ".";
        String[] newString = s.split("[.]");

        if (newString.length != 4)
            return false;

        boolean flag;
        for (int i = 0; i < newString.length; i++) {
            if (checkValid(newString[i])) {
                continue;
            } else return false;
        }

        return true;
    }

    public static boolean checkValid(String s) {

        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i)))
                return false;

        if (s.length() > 3)
            return false;

        try {

            if (Integer.parseInt(s) > 255 || Integer.parseInt(s) < 0)
                return false;
        } catch (Exception e) {
            return false;
        }

        if (s.charAt(0) == '0' && s.length() != 1)
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("127.0.0.1."));
        System.out.println(isValidIP("222.111.111.111."));
//        System.out.println(isValidIP("0000.0000.0000.0000"));
//        System.out.println(isValidIP("1.2.3.04"));
//        System.out.println(isValidIP(" "));
    }

}
