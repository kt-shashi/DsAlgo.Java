package com.shashi.dsalgo.array;

//You are given an array arr[] of N integers
//including 0. The task is to find the smallest
//positive number missing from the array.

//Input:
//1 2 3 4 5
//0 -10 1 3 -20
//Output:
//6
//2

import java.util.HashSet;

public class SmallestPositiveMissingNumber {

    //Store all elements in a HashSet
    //Now, search the n+1 natural numbers in hash set
    //if not present then return
    
    public static int findMissing(int a[], int n) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(a[i]);
        }

        int i = 1;
        for (; i <= n + 1; i++) {
            if (hashSet.contains(i)) {
                continue;
            } else {
                return i;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {0, -10, 1, 3, -20};

        System.out.println("--Output-- : " + findMissing(a1, 5));
        System.out.println("--Output-- : " + findMissing(a2, 5));
    }

}
