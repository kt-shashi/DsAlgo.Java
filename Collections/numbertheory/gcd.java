package com.shashi.dsalgo.numbertheory;

//Euclid's algorithm to find gdc

//GCD(16,10) = GCD(10,16%10) = GCD(10,6)
//GCD(10,6) = GCD(6,10%6) = GCD(6,4)
//GCD(6,4) = GCD(4,6%4) = GCD(4,2)
//GCD(4,2) = GCD(2,4%2) = GCD(2,0)

//If o, then a is answer

public class gcd {

    public static void main(String[] args) {
        int a = 10;
        int b = 16;

        int c;
        if (a > b)
            c = gcd(a, b);
        else
            c = gcd(b, a);

        System.out.println(c);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}
