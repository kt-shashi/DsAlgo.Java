package com.shashi.dsalgo.array;

public class RemoveDuplicatesInSortedArray {

    public static int remove_duplicate(int a[], int N) {
        //to store index of next unique element
        int j = 0;

        for (int i = 0; i < N - 1; i++) {

            // If current element is not equal to next element then
            // store that current element

            if (a[i] != a[i + 1]) {
                a[j] = a[i];
                j++;
            }
        }

        // Store the last element as whether  it is unique or repeated,
        // it hasn't been stored previously
        a[j] = a[N - 1];
        return ++j;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;

        n = remove_duplicate(arr, n);

        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

}
