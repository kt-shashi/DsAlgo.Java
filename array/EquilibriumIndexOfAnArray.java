package com.shashi.dsalgo.array;

public class EquilibriumIndexOfAnArray {

    public static int getEquilibrium(int a[]) {
        int totalSum = 0;
        int leftSum = 0;

        //calculate total sum
        for (int i = 0; i < a.length; i++)
            totalSum += a[i];

        //Subtract one element from totalSum and add it to leftSUm
        //This way we can get left sum in leftSum and right sum in totalSum
        for (int i = 0; i < a.length; i++) {
            totalSum -= a[i];
            if (leftSum == totalSum)
                return i;
            leftSum += a[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-7, 1, 5, 2, -4, 3, 0};

        int equilibrium = getEquilibrium(a);
        if (equilibrium == -1)
            System.out.println("Not found");
        else
            System.out.println(a[equilibrium]);
    }
}
