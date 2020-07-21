package com.shashi.dsalgo.mathematics;

public class SmallestDivisibleNumber {

    //Method 1:
    //Brute force approach

    public static long getSmallestDivNumBruteForce(int n) {

        if (n <= 2)
            return n;

        int lcm = findLCM(1, 2);
        for (int i = 3; i <= n; i++) {
            lcm = findLCM(lcm, i);
        }

        return lcm;
    }

    //Utility function to find LCM
    public static int findLCM(int n1, int n2) {
        int lcm = n1 > n2 ? n1 : n2;
        while (true) {
            if (lcm % n1 == 0 && lcm % n2 == 0)
                return lcm;
            lcm++;
        }
    }


    //Method 2:
    //Property: GCD * LCM = n1 * n2
    //Here we find LCM, lcm = ( n1 * n2 ) / gcd( n1 , n2 )

    public static long getSmallestDivNum(int n) {

        //Edge case
        if (n <= 2) {
            return n;
        }

        long lcm = 2;
        for (long i = 3; i <= n; i++) {
            lcm = ((lcm * i) / (gcdEuler(lcm, i)));
        }

        return lcm;
    }

    //Utility function to find GCD
    private static long gcdEuler(long a, long b) {
        if (b == 0)
            return a;
        return gcdEuler(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(getSmallestDivNumBruteForce(3));
        System.out.println(getSmallestDivNumBruteForce(6));
        System.out.println(getSmallestDivNumBruteForce(9));
        System.out.println(getSmallestDivNumBruteForce(12));
    }

}
