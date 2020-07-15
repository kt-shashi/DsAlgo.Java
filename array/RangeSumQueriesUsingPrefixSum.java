package com.shashi.dsalgo.array;

// Description : We are given an Array of n integers, We are given
// q queries having indices l and r . We have to find out
// sum between the given range of indices.
//Input
//[4, 5, 3, 2, 5]
//3
//0 3
//2 4
//1 3
//Output
//14 (4+5+3+2)
//10 (3+2+5)
//10 (5+3+2)

public class RangeSumQueriesUsingPrefixSum {

    public static void main(String[] args) {
        int[] a = {4, 5, 3, 2, 5};

        int sum = findSum(a, 0, 3);
        System.out.println(sum);

        sum = findSum(a, 2, 4);
        System.out.println(sum);

        sum = findSum(a, 1, 3);
        System.out.println(sum);
    }

    private static int findSum(int[] a, int l, int r) {

        int sum = 0;
        for (int i = l; i <= r; i++)
            sum += a[i];

        return sum;
    }

}
