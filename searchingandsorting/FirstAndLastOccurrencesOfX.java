package com.shashi.dsalgo.searchingandsorting;

import java.util.Scanner;

//Given a sorted array with possibly duplicate elements,
// the task is to find indexes of first and last
// occurrences of an element x in the given array.

//Input:
//5
//1 3 5 5 5 5 67 123 125
//7
//1 3 5 5 5 5 7 123 125
//Output:
//2 5
//6 6

//To find the first occurrence, we use binary search
//and if we find the element:
//Case1: It is the first element
//Case2: It is not the first element
//Hence, we store the current index, and
//again do binary search, in the left side

public class FirstAndLastOccurrencesOfX {

    public static void findFirstAndLastOccurrencesOfX(int a[], int n, int x) {

        int firstOccurence = -1;
        int start = 0;
        int end = n - 1;
        int mid;

        //Find first Occurence
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] == x) {
                firstOccurence = mid;
                end = mid - 1;
            } else if (a[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }

        start = 0;
        end = n - 1;
        mid = 0;
        int lastOccurence = -1;

        //Find last Occurence
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] == x) {
                lastOccurence = mid;
                start = mid + 1;
            } else if (a[mid] < x)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println("First: " + x + " : " + firstOccurence);
        System.out.println("Last: " + x + " : " + lastOccurence);
    }

    public static void main(String[] args) {
        int[] a2 = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        findFirstAndLastOccurrencesOfX(a2, 9, 5);
        int[] a3 = {1, 3, 5, 5, 5, 5, 7, 123, 125};
        findFirstAndLastOccurrencesOfX(a3, 9, 7);
    }

}
