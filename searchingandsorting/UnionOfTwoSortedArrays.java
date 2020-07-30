package com.shashi.dsalgo.searchingandsorting;

//Given two sorted arrays arr[] and brr[] of
// size N and M respectively. The task is to
// find the union of these two arrays.
//Union of two arrays can be defined as the
// common and distinct elements in the two arrays.

//Example 1:

//Input:
//N = 5, arr1[] = {1, 2, 3, 4, 5}
//M = 3, arr2 [] = {1, 2, 3}
//Output: 1 2 3 4 5
//Explanation: Distinct elements including
//both the arrays are: 1 2 3 4 5.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class UnionOfTwoSortedArrays {
    public static ArrayList<Integer> findUnion(int a[], int b[], int n, int m) {
        // add your code here
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!hashSet.contains(a[i]))
                hashSet.add(a[i]);
        }

        for (int i = 0; i < m; i++) {
            if (!hashSet.contains(b[i]))
                hashSet.add(b[i]);
        }

        for (int i : hashSet)
            arrayList.add(i);

        Collections.sort(arrayList);
        return arrayList;
    }


    public static void main(String[] args) {
        int arr1[] = {2, 2, 3, 4, 5};
        int arr2[] = {1, 1, 2, 3, 4};

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = findUnion(arr1, arr2, 5, 5);
        System.out.println(arrayList);
    }
}
