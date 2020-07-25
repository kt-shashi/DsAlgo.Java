package com.shashi.dsalgo.searchingandsorting;

//using binary search find square root
//If the mid is smaller, store the value,
//because next element could be larger
//Eg: n=5, 2X2 < 5 , but 3X# > 5]
//Hence, we store the smaller value

public class SquareRootUsingBinarySearch {

    public static long floorSqrt(long x) {

        long ans = 0;
        long low = 0;
        long high = x;

        while (low <= high) {
            long mid = (low + high) / 2;

            if ((mid * mid) == x)
                return mid;

            else if ((mid * mid) > x)
                high = mid - 1;

            else {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + " : " + floorSqrt(i));
        }
    }

}
