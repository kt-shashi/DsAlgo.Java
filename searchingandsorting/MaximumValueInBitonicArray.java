package com.shashi.dsalgo.searchingandsorting;

//Given an array of elements which is first increasing
// and then may be decreasing, find the maximum element
// in the array.
//Note: If the array is increasing then just print
// then last element will be the maximum value.

//Example:
//Input:
//2
//9
//1 15 25 45 42 21 17 12 11
//5
//1 45 47 50 5
//
//Output:
//45
//50

import java.util.Scanner;

//Approach:

//Find the mid element
//if a[mid] is greater than both it's neighbour
//then return

//if a[mid] is less than it's previous element,
//then the element would be in the left array, hence
//end = mid - 1

public class MaximumValueInBitonicArray {

    public static int findMax(int[] a, int n) {
        int start = 0;
        int end = n - 1;

        if (n == 1)
            return a[0];
        if (n == 2) {
            if (a[0] >= a[1]) {
                return a[0];
            } else return a[1];
        }

        if (a[0] > a[1])
            return a[0];
        if (a[n - 1] > a[n - 1])
            return a[n - 1];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[mid] < a[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            System.out.println(findMax(a, n));
        }
    }
}
