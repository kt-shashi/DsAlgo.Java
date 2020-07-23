package com.shashi.dsalgo.mathematics;

//Given a positive integer value N. The task is to
// find how many numbers less than or equal to N
// have numbers of divisors exactly equal to 3.

//Input :
//6
//10
//30

//Output :
//1
//2
//3

//Input : N = 16
//Output : 4 9
//4 and 9 have exactly three divisors.
//Divisor

//Input : N = 49
//Output : 4 9 25 49
//4, 9, 25 and 49 have exactly three divisors.

public class ExactlyThreeDivisors {

    //Naive approach:

    public static int exactly3DivisorsNaive(int N) {
        int count = 0;
        for (int i = 4; i < N; i++) {
            if (findNumberWithThreeDivisor(i)) {
                ++count;
            }
        }
        return count;
    }

    public static boolean findNumberWithThreeDivisor(int n) {
        int flag = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                flag++;
        }
        if (flag == 3) {
            return true;
        } else {
            return false;
        }
    }

    //Better Approach:
    public static int exactly3Divisors(int N) {
        int count = 0;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println("Divisible: " + i);
            }
        }

        return count;
    }

    public static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        int flag = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                flag = 1;
            }
        }
        if (flag == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
//        System.out.println(exactly3DivisorsNaive(6));
//        System.out.println(exactly3DivisorsNaive(10));
//        System.out.println(exactly3DivisorsNaive(30));

//        System.out.println(exactly3Divisors(6));
//        System.out.println(exactly3Divisors(10));
//        System.out.println(exactly3Divisors(30));

        System.out.println(exactly3Divisors(67));
    }
}
