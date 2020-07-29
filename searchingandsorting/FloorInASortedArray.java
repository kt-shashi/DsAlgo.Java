package com.shashi.dsalgo.searchingandsorting;

import java.util.Scanner;

// Given a sorted array arr[] of size N without
// duplicates, and given a value x. Find the
// floor of x in given array. Floor of x is
// defined as the largest element K in arr[]
// such that K is smaller than or equal to x.

//Input:
//3
//7 0
//1 2 8 10 11 12 19
//7 5
//1 2 8 10 11 12 19
//7 10
//1 2 8 10 11 12 19
//Output:
//-1
//1
//3


//Approach:
//Use binary search
//If a[ mid ] == x, then return index

//If a[ mid ] > x,then search for the element in right side

//If a[ mid ] < x,then save it in answer, and search if there is an
//element smaller than x and greater than answer

//If element at mid is smaller, then

public class FloorInASortedArray {

    public static int findFloor(int[] a, int n, int x) {
        int start = 0;
        int end = n - 1;
        int mid;
        int ans = -1;

        if (a[0] > x)
            return -1;
        if (a[0] == x)
            return 0;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n, x;
            n = sc.nextInt();
            x = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            System.out.println(findFloor(a, n, x));
        }
    }
}
