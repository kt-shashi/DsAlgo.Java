package com.shashi.dsalgo.searchingandsorting;

//Given an array A of N integers. The task is to find a
//peak element in it in O( log N ) .
//An array element is peak if it is not smaller than
//its neighbours. For corner elements, we need to
//consider only one neighbour.
//Note: There may be multiple peak element possible,
//in that case you may return any valid index (0 based indexing).

//Input:
//1 2 3
//3 4
//Output:
//1
//1

public class PeakElement {

    //Using binary search for this problem
    //Set start -> 0, end -> n-1
    //Loop until start <= end
    //  Find: mid = ( start + end ) / 2
    //  Case 1: mid is peak element
    //  Case 2: Mid has an element on the left, that is greater
    //          End = mid - 1
    //  Case 3: Mid has an element on the right, that is greater
    //          Start = mid + 1

    public static int peakElement(int[] a, int n) {
        if (n == 1)
            return 0;

        if (a[0] >= a[1]) {
            return 0;
        }
        if (a[n - 1] >= a[n - 2]) {
            return n - 1;
        }

        int start = 1;
        int end = n - 2;
        int mid;

        while (start <= end) {

            mid = (start + end) / 2;

            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
                return mid;

            else if (a[mid - 1] > a[mid])
                end = mid - 1;

            else
                start = mid + 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] a2 = {3, 4};

        System.out.println(peakElement(a1, 3));
        System.out.println(peakElement(a2, 2));
    }

}
