package com.shashi.dsalgo.searchingandsorting;

//Given a sorted and rotated array A of N distinct
// elements which is rotated at some point, and
// given an element K. The task is to find the
// index of the given element K in the array A.

//Input:
//5 6 7 8 9 10 1 2 3
//10
//3 1 2
//1
//3 5 1 2
//6

//Output:
//5
//1
//-1

//Explanation:
//Testcase 1: 10 is found at index 5.
//Testcase 2: 1 is found at index 1.
//Testcase 3: 6 doesn't exist.

//Expected Time Complexity: O(log N)
//Expected Auxiliary Space: O(1)

public class SearchInSortedAndRotatedArray {

    //Approach:
    //Find the index of smalled element
    //Apply binary search  in the array in
    //both the sorted halves

    public static int Search(int a[], int k) {
        int index = timesSorted(a, a.length);
        int low = 0, high = a.length - 1;

        int leftHalf = binarySearch(a, k, low, index - 1);
        int rightHalf = binarySearch(a, k, index, high);

        if (leftHalf == -1 && rightHalf == -1) {
            return leftHalf;
        } else {
            if (leftHalf != -1)
                return leftHalf;
            else
                return rightHalf;
        }
    }

    //utility function to find the index of smallest element
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

            if (a[mid] < a[prevElement] && a[mid] < a[nextElement]) {
                return mid;
            } else if (a[end] < a[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    //utility function to use Binarysearch
    public static int binarySearch(int[] a, int k, int lowerLimit, int upperLimit) {
        int middleValue;
        while (lowerLimit <= upperLimit) {
            middleValue = lowerLimit + (upperLimit - lowerLimit) / 2;
            if (a[middleValue] < k) {
                lowerLimit = middleValue + 1;
            } else if (a[middleValue] > k) {
                upperLimit = middleValue - 1;
            } else {
                return middleValue;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] a2 = {3, 1, 2};
        int[] a3 = {3, 5, 1, 2};

        System.out.println(Search(a1, 7));
        System.out.println(Search(a2, 1));
        System.out.println(Search(a3, 6));
    }

}
