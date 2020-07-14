package com.shashi.dsalgo.array;

//This technique shows how a nested for loop in few problems can be converted
//to single for loop and hence reducing the time complexity.

//Given an array of integers of size 'n'.
//Our aim is to calculate the maximum sum of 'k'
//consecutive elements in the array.
//
//Input  : arr[] = {100, 200, 300, 400}
//         k = 2
//Output : 700

//Applying sliding window technique:

//We compute the sum of first k elements out of n terms using a
//linear loop and store the sum in variable maxSum
//Then we will graze linearly over the array till it reaches the end and
//simultaneously keep track of window sum.
//To get the current sum of block of k elements just subtract the
// first element from the previous block and add the last element of the current block

public class SlidingWindowTechnique {

    private static int maxSum(int a[], int size) {

        if (a.length < size) {
            System.out.println("Invalid");
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < size; i++)
            maxSum += a[i];

        int windowSum = maxSum;
        for (int i = size; i < a.length; i++) {
            windowSum = windowSum + a[i] - a[i - size];

            if (windowSum > maxSum)
                maxSum = windowSum;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(arr, k));
    }

}
