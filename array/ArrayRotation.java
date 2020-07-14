package com.shashi.dsalgo.array;

//Method 1: By rotating the array one by one. Time C: 0(n*k) Space: O(1)

//Method 2: Juggling Algo:
//Divide the array into sets (No of sets= gcd(n,k))
//Move the elements within sets
//Time C: O(n) Space: O(1)

public class ArrayRotation {

    //Function to rotate an number ky k times
    private static void rotateArray(int[] a, int k) {
        while (k-- > 0) {
            shiftLeftByOne(a);
        }
    }

    //Utility function that shifts elements on by one to the left
    private static void shiftLeftByOne(int a[]) {
        int temp = a[0];
        int i = 0;
        for (; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[i] = temp;
    }

    //Juggling Algo

    //For every set:
    //Store the 1st element of set in temp
    //Move the other set elements
    //Add temp to the last index of set
    private static void jugglingAlgo(int a[], int n, int k) {

        int d = -1;     //To calculate the next index of element in set
        int i, j;       //loop counter (i- set) , (j- elements of set)
        int temp;       //To store the first element of the set

        for (i = 0; i < gcd(n, k); i++) {
            j = i;
            temp = a[i];

            while (true) {
                d = (j + k) % n;
                if (d == i)
                    break;

                a[j] = a[d];
                j = d;
            }

            a[j] = temp;
        }
    }

    //utility function to find GCD
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }


    //main function
    public static void main(String[] args) {
        //Shift by one
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        printArray(a);
        rotateArray(a, 4);
        printArray(a);

        //Juggling Algo
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        printArray(b);
        jugglingAlgo(b, 7, 2);
        printArray(b);
    }

    //utility function to print Array
    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

}
