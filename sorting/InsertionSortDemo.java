package com.shashi.dsalgo.sorting;

public class InsertionSortDemo {

    public static void main(String[] args) {

        int[] a = {36, 19, 29, 12, 5};
        insertionSortDemo(a);

        for (int i : a) {
            System.out.println(i);
        }

    }

    public static void insertionSortDemo(int[] a) {

        for (int i = 1; i < a.length; i++) {

            int temp = a[i];
            int j = i;

            while (j > 0 && a[j - 1] > temp) {
                a[j] = a[j - 1];        //shift the pervious elements
                j = j - 1;
            }

            a[j] = temp;

        }

    }
}
