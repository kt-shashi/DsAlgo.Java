package com.shashi.dsalgo.searchingandsorting;

//select the middle element as pivot
//move all elements smaller than the pivot to left of the array
//move all elements larger than the pivot to it's right in the array
//do this recursively at the left and right side

//Partition Algo:
//Select last element as the pivot point
//Now the array would be divided into 2 regions
//One with elements less than pivot, other with greater
//Maintain a pointer i (for region of elements lower than pivot)
//Start a loop, j from start to end-2
//If a[j] <= pivot element
//Then it must be put in the smaller region
//hence we increment i and swap a[i] and a[j]

public class QuickSortDemo {

    public static void quickSort(int[] a, int low, int high) {
        //find the pivot point, and sort the left and right subarray
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi, high);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }

        //swap the pivot to it's place
        swap(a, i + 1, high);
        return i + 1;
    }

    //utility function to swap 2 elements
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        int[] a = {36, 19, 29, 0, 3, 12, 5};
        int[] a1 = {2, 1, 5, 6, 7, 5, 8};
        quickSort(a1, 0, 6);

        for (int i : a1)
            System.out.print(i + " ");

    }
}
