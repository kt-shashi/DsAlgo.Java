package com.shashi.dsalgo.array;

import java.util.ArrayList;
import java.util.Collections;

//An element of array is leader if it is greater than or equal
//to all the elements to its right side.
//Also, the rightmost element is always a leader.
//Input:
//16 17 4 3 5 2
//1 2 3 4 0
//7 4 5 7 3
//4 1 4
//Output:
//17 5 2
//4 0
//7 7 3
//4 4

public class LeadersInAnArray {

    public static ArrayList<Integer> leaders(int a[], int n) {

        ArrayList<Integer> leaders = new ArrayList<Integer>();
        int maxElement = a[n - 1];

        //Select the last element as the maximun element
        //We traverse the array from the right, and if we find
        //an element greater than maxElement, we add the prev max Element
        //to out ArrayList and update the new max Element

        //Edge case: If we have reached the end, but the first element
        //is smaller than max Element, then we have to add the max Element
        //to the arraylist

        //Edge case: If we have reached the end, and the max Element is the
        //first element itself, then we have to update the max Element

        for (int i = n - 2; i >= 0; i--) {

            if (a[i] >= maxElement) {
                leaders.add(maxElement);
                maxElement = a[i];
            }

            if (i == 0 && a[i] < maxElement) {
                leaders.add(maxElement);
            }

            if (i == 0 && a[i] == maxElement) {
                leaders.add(maxElement);
            }

        }

        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        int a[] = {16, 17, 4, 3, 5, 2};
        int[] a2 = {4, 1, 4};
        int[] a3 = {5, 4, 3, 2, 1};

        ArrayList<Integer> leaderArrayList = leaders(a, 6);
        System.out.println(leaderArrayList);

        leaderArrayList = leaders(a2, 3);
        System.out.println(leaderArrayList);

        leaderArrayList = leaders(a3, 5);
        System.out.println(leaderArrayList);
    }
}
