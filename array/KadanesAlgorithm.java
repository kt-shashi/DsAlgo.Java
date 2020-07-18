package com.shashi.dsalgo.array;

//Given an array arr of N integers.
//Find the contiguous sub-array with maximum sum.

//Input:
// 1 2 3 -2 5
//-1 -2 -3 -4

//Output:
//9
//-1

public class KadanesAlgorithm {

// Simple idea of the Kadane’s algorithm is to look for all positive
// contiguous segments of the array (currentSum is used for this).
// And keep track of maximum sum contiguous segment among all
// positive segments (maxSum is used for this).
// Each time we get a positive sum compare it with maxSum and update maxSum
// if it is greater than maxSum

    public static int maxSubarraySum(int a[], int n) {

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currentSum += a[i];

            if (currentSum > maxSum)
                maxSum = currentSum;

            if (currentSum < 0)
                currentSum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, -2, 5};
        int[] a2 = {-1, -2, -3, -4};
        int[] a3 = {74, -72, 94, -53, -59, -3, -66, 36, -13, 22, 73, 15, -52, 75};

        System.out.println(maxSubarraySum(a1, 5));
        System.out.println(maxSubarraySum(a2, 4));
        System.out.println(maxSubarraySum(a3, 14));
    }
}
