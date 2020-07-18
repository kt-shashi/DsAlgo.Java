package com.shashi.dsalgo.array;

//Given an array arr[] of size N. The task is to find
//the first repeating element in an array of integers,
//i.e., an element that occurs more than once and whose
//index of first occurrence is smallest.

//Input:
//3
//7
//1 5 3 4 3 5 6
//4
//1 2 3 4
//5
//1 2 2 1 3
//
//Output:
//2
//-1
//1

import java.util.HashSet;

public class FirstRepeatingElement {

    //Naive approach
    public static int firstRepeated(int[] a, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    return i + 1;
                } else
                    continue;
            }
        }

        return -1;
    }

    //Using hashing
    public static int firstRepeatedUsingHashing(int[] a, int n) {

        HashSet<Integer> hashSet = new HashSet<>();
        int repeated = -1;

        hashSet.add(a[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (hashSet.contains(a[i])) {
                repeated = i + 1;
            } else {
                hashSet.add(a[i]);
                continue;
            }
        }

        return repeated;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 4, 3, 5, 6};
        int[] a2 = {1, 2, 3, 4};
        int[] a3 = {1, 2, 2, 1, 3};

        System.out.println(firstRepeated(a1, 7));
        System.out.println(firstRepeated(a2, 4));
        System.out.println(firstRepeated(a3, 5));

        System.out.println();

        System.out.println(firstRepeatedUsingHashing(a1, 7));
        System.out.println(firstRepeatedUsingHashing(a2, 4));
        System.out.println(firstRepeatedUsingHashing(a3, 5));
    }
}
