package com.shashi.dsalgo.array;

//Given an array arr[] of size N where every element
//is in the range from 0 to n-1. Rearrange the given
//array so that arr[i] becomes arr[arr[i]].

//If a[i]=j ,then a[j]=i

//Input:
//1 0
//4 0 2 1 3
//3 2 0 1

//Output:
//0 1
//3 4 2 0 1
//1 0 3 2

//Naive approach using o(n) space
//for (int i = 0; i < n; i++)
//     temp[i] = a[a[i]];
//for (int i = 0; i < temp.length; i++)
//      a[i] = temp[i];

//Approach using o(1) space

//n: size of array
//We use the formula: oldValue = oldValue + ( newValue * n )

//To get oldValue: element % size
//To get newElement: element / size

public class RearrangeAnArray {

    public static void arrange(long a[], int n) {
        for (int i = 0; i < n; i++)
            a[i] += (a[(int) a[i]] % n) * n;

        for (int i = 0; i < n; i++)
            a[i] /= n;
    }

    public static void main(String[] args) {
        long[] a1 = {1, 0};
        long[] a2 = {4, 0, 2, 1, 3};
        long[] a3 = {3, 2, 0, 1};

        arrange(a1, 2);
        arrange(a2, 5);
        arrange(a3, 4);
        print(a1);
        print(a2);
        print(a3);
    }

    public static void print(long a[]) {
        System.out.println();
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
