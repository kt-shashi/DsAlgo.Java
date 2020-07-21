package com.shashi.dsalgo.mathematics;

//Program to find LCM of 2 numbers

//Eg: 2 and 6
//LCM: 6

//Approach:
// Find the max input and store it in number
// increase the number until it is divisible
// by both the inputs
public class LCM {

    public static int findLCM(int n1, int n2) {
        int lcm = n1 > n2 ? n1 : n2;
        while (true) {
            if (lcm % n1 == 0 && lcm % n2 == 0)
                return lcm;
            lcm++;
        }
    }

    public static void main(String[] args) {
        System.out.println(findLCM(2, 3));
        System.out.println(findLCM(2, 6));
        System.out.println(findLCM(10, 6));
    }

}
