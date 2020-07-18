package com.shashi.dsalgo.array;

//Given an array arr[] of size N containing positive
//integers and an integer X. You need to find the value
//in the array which is smaller than X and closest to it.

//Sample Input:
//4 67 13 12 15
//16
//1 2 3 4 5
//1
//Sample Output:
//15
//-1
//Explanation:
//Testcase 1:  For a given value 16, there are four
//values which are smaller than it. But 15 is the number
//which is smaller and closest to it with minimum difference of 1.
//Testcase 2: For a given value 1, no value is smaller
//than it and closest to it in the given array.

public class FindImmediateSmallerThanX {

    //For every element
    //If it is less than X and the difference is smaller than prev
    //store current index in smallest variable
    //and store the current difference in deiff
    public static int immediateSmaller(int a[], int n, int x) {
        int smaller = -1;
        int difference = 999999;
        for (int i = 0; i < n; i++) {
            if (a[i] < x && (x - a[i]) < difference) {
                smaller = i;
                difference = x - a[i];
            }
        }

        if (smaller == -1)
            return smaller;
        else
            return a[smaller];
    }

    public static void main(String[] args) {
        int[] a1 = {4, 67, 13, 12, 15};
        int[] a2 = {1, 2, 3, 4, 5};
        int[] a3 = {1, 9, 6, 7, 2, 3, 0, 1, 10};
        int[] a4 = {1};

        System.out.println(immediateSmaller(a1, 5, 16));
        System.out.println(immediateSmaller(a2, 5, 1));
        System.out.println(immediateSmaller(a3, 9, 8));
        System.out.println(immediateSmaller(a4, 1, 2));

    }

}
