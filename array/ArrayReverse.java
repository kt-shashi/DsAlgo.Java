package com.shashi.dsalgo.array;

public class ArrayReverse {

    private static void reverseUsingRecursion(int a[], int start, int end) {

    }

    private static void reverseUsingLoop(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 5 , 99};

        printArray(a);
        reverseUsingLoop(a, 0, 5);
        printArray(a);

    }

    //utility function to print Array
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}
