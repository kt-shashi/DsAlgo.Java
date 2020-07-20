package com.shashi.dsalgo.array;

public class TrappingRainWater {

    //1. naive approach:

    //For every tower
    //1. Find it's max tower height from left and right
    //2. Take the min from the 2 max
    //3. Subtract the tower height from the min
    public static int trappingWaterNaive(int a[], int n) {

        int water = 0;

        for (int i = 1; i < n - 1; i++) {
            int largestNumberLeft = findMax(a, 0, i + 1);
            int largestNumberRight = findMax(a, i, n);

            if (largestNumberLeft < largestNumberRight)
                water = water + (largestNumberLeft - a[i]);
            else
                water = water + (largestNumberRight - a[i]);
        }

        return water;
    }

    //utility function to find the max
    private static int findMax(int a[], int l, int u) {
        int max = -1;
        for (int i = l; i < u; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    //0(n) solution:

    //Find the max hjeight of tower for left and right and store in array
    //Find the water stored
    //-> minimun ( leftMax[i] , rightMax[i] ) - a[i] (height of building)
    public static int trappingWater(int a[], int n) {

        //Find leftMax of all towers
        int[] leftMax = new int[n];
        leftMax[0] = a[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = getMax(leftMax[i - 1], a[i]);

        //Find rightMax of all towers
        int[] rightMax = new int[n];
        rightMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = getMax(a[i], rightMax[i + 1]);

        //Find the water stored between the towers
        int[] waterStored = new int[n];
        for (int i = 0; i < n; i++)
            waterStored[i] = getMin(leftMax[i], rightMax[i]) - a[i];

        //Find the total water stored
        int sumWaterStored = 0;
        for (int i = 0; i < n; i++)
            sumWaterStored += waterStored[i];

        return sumWaterStored;
    }

    //utility function to find Max between 2 elements
    public static int getMax(int a, int b) {
        if (a > b) return a;
        else return b;
    }

    //utility function to find Min between 2 elements
    public static int getMin(int a, int b) {
        if (a < b) return a;
        else return b;
    }


    public static void main(String[] args) {
        int a1[] = {3, 0, 0, 2, 0, 4};      //10
        int a2[] = {7, 4, 0, 9};            //10
        int a3[] = {6, 9, 9};               //0

        System.out.println(trappingWater(a1, 6));
        System.out.println(trappingWater(a2, 4));
        System.out.println(trappingWater(a3, 3));
    }
}
