package com.shashi.dsalgo.searchingandsorting;

//Given an infinite sorted array consisting 0s and 1s.
// The problem is to find the index of first ‘1’ in
// that array. As the array is infinite, therefore
// it is guaranteed that number ‘1’ will be
// present in the array.


//Approach
//Find the bound in which 1 lies
//Find the first occurrence

//To find bound, we shift end to right until we find
//an element that is greater than a[previous]

//To find first occurence of 1
//We check if a[ mid ] is 1
//If yes, then it may be a possible ans, or
//there ,might be a lesser index.
//Hence, we store the index, and continue searching
//In the left side of the array
//Otherwise if we encounter a index with value lesser than 1,
//we try finding to the right side of the array

public class IndexOfFirst1InBinarySortedInfiniteArray {

    //Function to find first position of 1
    public static int posOfFirstOne(int[] a) {
        int start = 0;
        int end = a.length - 1;

        while (a[end] < 1) {
            start = end;
            end = end * 2;
        }

        int answer = findFirstOccurence(a, start, end);
        return answer;
    }

    //Utility function to find the first position
    //in a given bound
    private static int findFirstOccurence(int[] a, int start, int end) {
        int answer = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == 1) {
                answer = mid;
                end = mid - 1;
            } else if (a[mid] < 1) {
                start = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println("Index = " + posOfFirstOne(arr));
    }

}
