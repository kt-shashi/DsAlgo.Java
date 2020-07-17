package com.shashi.dsalgo.array;

public class SubarrayWithGivenSum {

    public static void subarraySum(int[] a, int n, int programSum) {
        int i = 0, j = 0, sum = 0;

        //Add elements one by one and add to currentSum until
        //we have found the program sum
        //If the currentSum is greater than program sum,
        //then subtract the trailing elements from the left
        //If the current sum if less than program sum, keep adding the next element

        while (i < n && j < n) {

            if (sum + a[j] == programSum) {
                System.out.print((i + 1) + " " + (j + 1));
                return;
            }

            if (sum + a[j] < programSum) {
                sum += a[j];
                j++;
                continue;
            }

            if (sum + a[j] > programSum) {
                sum -= a[i];
                i++;
                continue;
            }
        }

        System.out.print("-1");
    }


    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 7, 5};
        int[] a2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] a3 = {5, 7, 1, 2};

        subarraySum(a1, 5, 12);
        System.out.println();
        subarraySum(a2, 10, 15);
        System.out.println();
        subarraySum(a3, 4, 15);
        System.out.println();
    }

}
