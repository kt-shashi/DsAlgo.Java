package com.shashi.dsalgo.searchingandsorting;

public class MergeSortDemo {

    public static void main(String[] args) {

        int a[] = {10,5,3,8,6,3,8,2,7};

        mergeSortDemo(a, 0, 8);

        for (int i : a)
            System.out.print(i + " ");

    }

    public static void mergeSortDemo(int[] a, int s, int e) {

        if (s >= e) {
            return;     //do not need to sort array with single element
        }

        //Divide the array
        int mid = (s + e) / 2;
        mergeSortDemo(a, s, mid);
        mergeSortDemo(a, mid + 1, e);

        //Merge the array
        merge(a,s,e);

    }

    public static void merge(int[] a, int s, int e) {

        int mid = (s + e) / 2;

        int i = s;
        int j = mid + 1;
        int k = s;

        int[] c = new int[100];

        while (i <= mid && j <= e) {
            if (a[i] < a[j])
                c[k++] = a[i++];
            else
                c[k++] = a[j++];
        }

        while (i <= mid)
            c[k++] = a[i++];

        while (j <= e)
            c[k++] = a[j++];

        for (int ii = s; ii <= e; ii++)
            a[ii] = c[ii];
    }

}
