package com.shashi.dsalgo.searchingandsorting;


//Approach:

//Case 1: Key is present: key is the ans

//Case 2: Key is not Present:
// The least difference present would be the
// neighbours of where the key should have been present
//Eg: 1 3 5 18 20 34
//Key : 12
//If we want the minimum difference would be from
// either 5 or 18
// i.e. neighbours of where the key should be present

import java.util.Arrays;

public class MinimumDifferencePair {

    static int findMinDiff(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == key) {
                return 0;
            } else if (a[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }

        int firstNeighbourDiff = Math.abs(a[start] - key);
        int secondNeighbourDiff = Math.abs(a[end] - key);

        return Math.min(firstNeighbourDiff, secondNeighbourDiff);
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 7, 16, 18, 19, 20, 21, 22, 25};
        System.out.println("Minimum difference is " +
                findMinDiff(a, 17));
    }

    //for finding minimum from all elements, in an unsorted array

    //1) Sort array in ascending order
    //3) Compare all adjacent pairs in sorted array and keep
    // track of minimum difference

    static int findMinDiffInAll(int[] arr, int n) {
        // Sort array in non-decreasing order
        Arrays.sort(arr);

        // Initialize difference as infinite
        int diff = Integer.MAX_VALUE;

        // Find the min diff by comparing adjacent
        // pairs in sorted array
        for (int i = 0; i < n - 1; i++)
            if (arr[i + 1] - arr[i] < diff)
                diff = arr[i + 1] - arr[i];

        // Return min diff
        return diff;
    }

}
