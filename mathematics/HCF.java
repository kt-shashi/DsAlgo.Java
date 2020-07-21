package com.shashi.dsalgo.mathematics;

//Program to find HCF of 2 numbers

//Eg: 12 and 15
//HCF: 3

//Approach:
// Find the min input and store it in number
// Decrease the number until it divides both the inputs

public class HCF {

    public static int findHCF(int n1, int n2) {
        int hcf = n1 < n2 ? n1 : n2;
        while (true) {
            if (n1 % hcf == 0 && n2 % hcf == 0)
                return hcf;
            --hcf;
        }
    }

    public static void main(String[] args) {
        System.out.println(findHCF(12, 15));
        System.out.println(findHCF(12, 20));
        System.out.println(findHCF(10, 5));
    }

}
