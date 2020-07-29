package com.shashi.dsalgo.searchingandsorting;

//If element at mid is greater, then it could be the ans
//Hence we store it, and find is there an element which is also
//larger than K, but is smaller than the previous ans
//And we go to the left half, end = mid - 1

public class NextAlphabeticalElement {

    public static char nextGreatestAlphabet(char[] letters, char K) {
        int start = 0;
        int end = letters.length - 1;

        char ans = '#';

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] == K) {
                start = mid + 1;
            } else if (letters[mid] > K) {
                ans = letters[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        char letters[] = {'A', 'B', 'G', 'J', 'K', 'S'};
        char K = 'F';
        char result = nextGreatestAlphabet(letters, K);
        if (result == '#')
            System.out.println("Not found");
        else
            System.out.println(result);
    }
}
