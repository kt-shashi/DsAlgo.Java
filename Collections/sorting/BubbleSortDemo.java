package com.shashi.dsalgo.sorting;

public class BubbleSortDemo {

    public static void main(String[] args) {

        int[] a = {36, 19, 29, 12, 5, 6};
        bubbleSortDemo(a);

        for (int i : a) {
            System.out.println(i);
        }

    }

    public static void bubbleSortDemo(int a[]) {

        for (int i = 0; i < a.length - 1; i++) {

            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }

            }

        }

    }

    public static void improvedBubbleSortDemo(int a[]) {

        for (int i = 0; i < a.length - 1; i++) {

            int flag = 0;

            for (int j = 0; j < a.length - i - 1; j++) {

                if (a[j + 1] < a[j]) {

                    flag = 1;
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;

                }

            }

            if (flag == 0)
                break;

        }

    }

}
