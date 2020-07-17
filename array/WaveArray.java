package com.shashi.dsalgo.array;

public class WaveArray {

    // Function to convert the given array to wave like array
    // arr: input array
    // n: size of the array
    public static void convertToWave(int a[], int n) {

        for (int i = 0; i < n; i += 2) {
            if (i == n - 1)
                return;

            int temp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 4, 7, 8, 9, 20};

        convertToWave(a1, 5);
        convertToWave(a2, 6);

        printArray(a1);
        printArray(a2);
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}