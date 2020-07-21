package com.shashi.dsalgo.mathematics;

//make a boolean array of size N and initialize with true
//mark 0 and 1 as false
// for i- 2 to root n
//mark the multiples of i as false starting from i*i
//Eg: say we want to find for 3X2, then that
//would already be handled in 2X3

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {

        boolean[] a = sievePrime(50);

        for (int i = 0; i < a.length; i++) {
            if (a[i] == true)
                System.out.print(i + " ");
        }

    }

    public static boolean[] sievePrime(int n) {

        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int i = 2; i * i <= n; i++) {

            if (sieve[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }

        }

        return sieve;
    }

}
