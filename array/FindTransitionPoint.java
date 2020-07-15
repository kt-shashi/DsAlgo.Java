package com.shashi.dsalgo.array;

//You are given a sorted array containing only numbers 0 and 1.
//Find the transition point efficiently. The transition point is
//a point where "0" ends and "1" begins (0 based indexing).
//Note that, if there is no "1" exists, print -1.
//Note that, in case of all 1s print 0.

public class FindTransitionPoint {

    public static int transitionPoint(int a[], int n) {
        if(n==1){
            if(a[0]==0)
                return -1;
            if(a[0]==1)
                return 0;
        }

        // code here
        boolean allOne = false;

        for (int i = 1; i < n; i++) {
            //Case 1: if we found the transition
            if (a[i - 1] != a[i])
                return i + 1;
            //if all one

            if (a[i - 1] == 1 && a[i] == 1)
                allOne = true;
        }

        if (allOne)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] a1 = {0, 0, 0, 1, 1};
        int[] a2 = {0, 0, 0, 0};
        int[] a3 = {1, 1, 1};

        System.out.println(transitionPoint(a1, 5));
        System.out.println(transitionPoint(a2, 4));
        System.out.println(transitionPoint(a3, 3));
    }

}
