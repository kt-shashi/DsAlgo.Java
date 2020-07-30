package com.shashi.dsalgo.searchingandsorting;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class IntersectionOfTwoSortedArrays {
    static ArrayList<Integer> printIntersection(int a[], int b[], int n, int m) {
        // add your code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0, j = 0;
        int prev = -1;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                if (a[i] != prev) {
                    arrayList.add(a[i]);
                    prev = a[i];
                    i++;
                    j++;
                }
            }
        }
        return arrayList;
    }

    static ArrayList<Integer> printIntersectionUsingHash(int a[], int b[], int n, int m) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++)
            hashSet.add(a[i]);

        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (hashSet.contains(b[i]) && b[i] != prev) {
                arrayList.add(b[i]);
                prev = b[i];
            }
        }

        Collections.sort(arrayList);
        return arrayList;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 2, 3, 4, 5};
        int arr2[] = {1, 1, 2, 3, 4};

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = printIntersectionUsingHash(arr1, arr2, 5, 5);
        System.out.println(arrayList);
    }
}
