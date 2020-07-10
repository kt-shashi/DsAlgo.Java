package com.shashi.dsalgo.backtracking;;

import java.util.Scanner;

public class NQueenProblem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] board = new int[10][10];

        solveNQueen(board, 0, n);

    }

    public static boolean isSafe(int[][] board, int i, int j, int n) {

        //Check if there is a queen in the row
        for (int row = 0; row < i; row++) {
            if (board[row][j] == 1) return false;
        }

        //Check for Left diagonal
        int x = i;
        int y = j;

        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) return false;
            x--;
            y--;
        }

        //Check for Right diagonal
        x = i;
        y = j;

        while (x >= 0 && y < n) {
            if (board[x][y] == 1) return false;
            x--;
            y++;
        }

        return true;

    }

    public static boolean solveNQueen(int board[][], int i, int n) {

        if (i >= n) {
            //successfully placed the queens
            //print
            printBoard(board, n);
            return true;
        }

        //Recursive case
        //Try to place the Queen in the current row and and call on the remaining part

        for (int j = 0; j < n; j++) {

            //Check if it is safe to put the queen
            if (isSafe(board, i, j, n)) {
                board[i][j] = 1;    //Place the queen assuming i,j is right position


                boolean isSolved = solveNQueen(board, i + 1, n);
                if (isSolved) {
                    return true;
                }

                board[i][j] = 0;      //If assumption was wrong, backtrack

            }

        }

        return false;
    }

    public static void printBoard(int board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
