package com.shashi.dsalgo.searchingandsorting;

//Given a bitonic sequence of n distinct elements,
// write a program to find a given element x in
// the bitonic sequence in O(log n) time. A
// Bitonic Sequence is a sequence of numbers which
// is first strictly increasing then after a point
// strictly decreasing.

//Examples:

//Input :  arr[] = {-3, 9, 8, 20, 17, 5, 1};
//         key = 20
//Output : Found at index 3

//Input :  arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
//         key = 30
//Output : Not Found

//Approach:
//Find the bitonic point (Max element)
//Use binary search in left half
//Use binary search for dec order in right half

public class SearchAnElementinBitonicArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 7, 9, 20, 18, 17, 16, 12, 11};
        int key = 11;

        System.out.println(searchBitonic(arr, key));
    }

    //Function to find if element is present or not
    public static int searchBitonic(int[] a, int key) {
        int bitonicIndex = findMax(a, a.length);
        int leftResult = binarySearch(a, key, 0, bitonicIndex - 1);
        int rightResult = binarySearchDes(a, key, bitonicIndex, a.length - 1);

        if (leftResult != -1)
            return leftResult;
        else
            return rightResult;
    }

    //Utility function to find the bitonic point
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

    //Utility function to find am element using Binary Search
    public static int binarySearch(int[] a, int key, int lowerLimit, int upperLimit) {
        int middleValue;

        while (lowerLimit <= upperLimit) {
            middleValue = (lowerLimit + upperLimit) / 2;
            if (a[middleValue] < key) {
                lowerLimit = middleValue + 1;
            } else if (a[middleValue] > key) {
                upperLimit = middleValue - 1;
            } else {
                return middleValue;
            }
        }

        return -1;
    }

    //Utility function to find decreasing sorted array using Binary search
    public static int binarySearchDes(int[] a, int key, int lowerLimit, int upperLimit) {
        int mid;
        while (lowerLimit <= upperLimit) {
            mid = lowerLimit + (upperLimit - lowerLimit) / 2;
            if (a[mid] == key)
                return mid;
            else if (a[mid] > key)
                lowerLimit = mid + 1;
            else
                upperLimit = mid - 1;
        }
        return -1;
    }

}
