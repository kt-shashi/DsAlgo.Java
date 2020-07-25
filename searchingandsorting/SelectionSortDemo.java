package com.shashi.dsalgo.searchingandsorting;

public class SelectionSortDemo {
    public static void main(String[] args) {

        int[] a = {36, 19, 29, 12, 5, 6};
        selectionSortDemo(a);

        for (int i : a) {
            System.out.println(i);
        }

    }

    public static void selectionSortDemo(int[] a) {

        for (int i = 0; i < a.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < a.length; j++) {

                if (a[j] < a[minIndex])
                    minIndex = j;

            }

            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;

        }

    }
}

