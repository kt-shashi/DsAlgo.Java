package com.shashi.dsalgo.searchingandsorting;

//Given a sorted array A of size N.
// The array is rotated 'K' times.
// Find the value of 'K'.
// The array may contain duplicate elements.

//Input
//5 1 2 3 4
//1 2 3 4 5
//Output
//1
//0

//Approach:
//Here, no of rotations is the index of the smallest element
//TO find smallest element, we use binary search

//Check mid with it's neighbours
//Eg: 5 1 2 3 4 -> 1 is less than both it's neighbours,
//hence, it's the smallest element
//If mid == smallest, return mid
//Now we have to move, either to left or right

//11 12 15 18 2 5 6 8
//here, once we have 18 as mid.
//now we move to the right subarray. because it is not sorted

//To find left subarray is sorted (from start to mid):
//find the difference between a[mid] and a[start]
//for a sorted array, diff is always positive

//To find right subarray is sorted (from mid to end):
//find the difference between a[end] and a[mid]
//for a sorted array, diff is always positive

public class NumberOfTimesSortedArrayIsRotated {

    public static int timesSorted(int[] a, int n) {
        int start = 0;
        int end = n - 1;
        if (a[start] < a[end]) {
            return 0;
        }

        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int prevElement = (mid - 1 + n) % n;
            int nextElement = (mid + 1) % n;

            if (a[mid] < a[prevElement] && a[mid] <= a[nextElement]) {
                return mid;
            } else if (a[end] < a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {11, 12, 15, 18, 2, 5, 7, 9};
//        int[] a3 = {5, 1, 2, 3, 4};
        int[] a3 = {5, 8, 10, 11, 0, 1, 2, 3};

        System.out.println(timesSorted(a1, 5));
        System.out.println(timesSorted(a2, 8));
        System.out.println(timesSorted(a3, 5));

    }
}
