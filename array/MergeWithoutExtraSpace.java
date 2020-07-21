package com.shashi.dsalgo.array;

//Iterate through every element of ar2[] starting from last
//element. Do following for every element ar2[i]

//    a) Store last element of ar1[i]: last = ar1[i]
//    b) Loop from last element of ar1[] while element ar1[j] is
//       smaller than ar2[i].
//          ar1[j+1] = ar1[j] // Move element one position ahead
//          j--
//    c) If any element of ar1[] was moved or (j != m-1)
//          ar1[j+1] = ar2[i]
//          ar2[i] = last

public class MergeWithoutExtraSpace {
    public static void merge(int a1[], int a2[], int m, int n) {
        for (int i = n - 1; i >= 0; i--) {
            int lastElement = a1[m - 1];
            int j = m - 2;
            while (j >= 0 && a1[j] > a2[i]) {
                a1[j + 1] = a1[j];
                j--;
            }
            if (j != m - 2 || lastElement > a2[i]) {
                a1[j + 1] = a2[i];
                a2[i] = lastElement;
            }
        }
    }

    public static void main(String[] args) {

    }

}
