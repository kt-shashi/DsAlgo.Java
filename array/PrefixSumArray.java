package com.shashi.dsalgo.array;

//Prefix Sum Array: The prefix sum array of any array,
//arr[] is defined as an array of same size say, prefixSum[]
//such that the value at any index i in prefixSum[] is
//sum of all elements from indexes 0 to i in arr[].

//Input  : arr[] = {10, 20, 10, 5, 15}
//Output : prefixSum[] = {10, 30, 40, 45, 60}

public class PrefixSumArray {

    private static int[] prefixsumArray(int[] a) {
        int[] prefixSum = new int[a.length];

        prefixSum[0] = a[0];
        for (int i = 1; i < a.length; i++)
            prefixSum[i] = prefixSum[i - 1] + a[i];

        return prefixSum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 5, 15};
        int[] prefixSum = prefixsumArray(arr);

        for (int i = 0; i < prefixSum.length; i++)
            System.out.print(prefixSum[i] + " ");
        System.out.println();
    }

}
