package com.shashi.dsalgo.searchingandsorting;

//condition: array must be sorted

public class BinarySearchDemo {

    public static void main(String[] args) {

        int a[] = {1, 2, 4, 5, 7, 8, 9};

        int a2[] = {9, 8, 7, 5, 4, 2, 1};
        int indexReturned;

        indexReturned = binarySearch(a, 4, 0, a.length - 1);
        if (indexReturned == -1) {
            System.out.println("not found");
        } else {
            System.out.println("Element found: " + indexReturned + "th index");
        }

        indexReturned = binarySearchDes(a2, 7, 0, a2.length - 1);
        if (indexReturned == -1) {
            System.out.println("not found");
        } else {
            System.out.println("Element found: " + indexReturned + "th index");
        }
    }

    public static int binarySearch(int[] a, int key, int lowerLimit, int upperLimit) {
        int middleValue;

        while (lowerLimit <= upperLimit) {
            middleValue = (lowerLimit + upperLimit) / 2;
            if (a[middleValue] < key) {
                lowerLimit = middleValue + 1;
            } else if (a[middleValue] > key) {
                upperLimit = middleValue - 1;
            } else {
                return middleValue;
            }
        }

        return -1;
    }

    public static int binarySearchDes(int[] a, int key, int lowerLimit, int upperLimit) {
        int mid;

        while (lowerLimit <= upperLimit) {
            mid = lowerLimit + (upperLimit - lowerLimit) / 2;
            if (a[mid] == key)
                return mid;
            else if (a[mid] > key)
                lowerLimit = mid + 1;
            else
                upperLimit = mid - 1;
        }

        return -1;
    }

}
