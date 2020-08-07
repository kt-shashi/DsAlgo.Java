package com.shashi.dsalgo.stringdemo;

import java.util.HashSet;

//Approach (Sliding window technique -> O(n) ):

//we use hashset to store already visited characters

//Maintain 2 pointers

//If the currentPointer is already present in hashSet
//then reduce the size of the window form the left
//using previous pointer

//Else, we simple add the item to the hashset, and
//increment currentPointer

public class LongestSubstringWithoutRepeatingCharacters {

    public static int subSequenceLength(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int previousPoniter = 0;
        int currentPointer = 0;
        int maxSize = Integer.MIN_VALUE;
        HashSet<Character> hashSet = new HashSet<>();

        while (currentPointer < s.length()) {
            char ch = s.charAt(currentPointer);

            while (hashSet.contains(ch)) {
                hashSet.remove(s.charAt(previousPoniter));
                previousPoniter++;
            }

            hashSet.add(ch);
            maxSize = Math.max(maxSize, currentPointer - previousPoniter + 1);
            currentPointer++;
        }

        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(subSequenceLength("geeksforgeeks"));
        System.out.println(subSequenceLength("lmaonoob"));
        System.out.println(subSequenceLength("aab"));
        System.out.println(subSequenceLength("abb"));
        System.out.println(subSequenceLength("a"));
        //abcabcbb
    }
}
