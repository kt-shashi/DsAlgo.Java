package com.shashi.dsalgo.searchingandsorting;

//select the middle element as pivot
//move all elements smaller than the pivot to left of the array
//move all elements larger than the pivot to it's right in the array
//do this recursively at the left and right side

public class QuickSortDemo {

    public static void main(String[] args) {

        int[] a = {36, 19, 29, 0, 3, 12, 5};
        quickSortDemo(a, 0, 6);

        for (int i : a)
            System.out.print(i + " ");

    }

    public static void quickSortDemo(int[] a, int low, int high) {
        int pi = partition(a, low, high);
        if (low < pi - 1) quickSortDemo(a, low, pi - 1);
        if (pi < high) quickSortDemo(a, pi, high);
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[(low + high) / 2];     //middle element
        while (low <= high) {
            while (a[low] < pivot) low++;
            while (a[high] > pivot) high--;
            //swap
            if (low <= high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;

                low++;
                high--;
            }
        }
        return low;
    }

}
