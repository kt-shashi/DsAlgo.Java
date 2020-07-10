package com.shashi.dsalgo.sorting;

//condition: array must be sorted

public class BinarySearchDemo {

    public static void main(String[] args) {

        int a[] = {1, 2, 4, 5, 7, 8, 9};
        int n = 8;

        int indexReturned = binarySearch(a, n);

        if (indexReturned == -1) {
            System.out.println("not found");
        } else {
            System.out.println("Element found: " + indexReturned + "th index");
        }
    }

    public static int binarySearch(int[] a, int n) {

        int lowerLimit = 0;
        int upperLimit = a.length;
        int middleValue = (lowerLimit + upperLimit) / 2;

        while (lowerLimit < upperLimit) {
            if (a[middleValue] < n) {
                lowerLimit = middleValue + 1;
            } else if (a[middleValue] > n) {
                upperLimit = middleValue - 1;
            } else {
                return middleValue;
            }
            middleValue = (lowerLimit + upperLimit) / 2;
        }

        return -1;

    }

}


