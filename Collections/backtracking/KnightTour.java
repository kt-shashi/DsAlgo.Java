package com.shashi.dsalgo.backtracking;

import java.lang.reflect.Array;
import java.util.Scanner;

public class KnightTour {

//    The knight is placed on the first block of an empty board
//    moving according to the rules of chess
//    must visit each square exactly once.

    public static void main(String[] args) {
        int board[][] = new int[8][8];
        board[0][0] = 1;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter board dimension");
        int n = sc.nextInt();
        boolean ans = solveKnightTour(board, n, 1, 0, 0);
        if (ans) {
            printBoard(board, n);
        } else {
            System.out.println("Cannot visit your Board");
        }
    }

    public static boolean solveKnightTour(int board[][], int n, int move_no, int curRow, int curCol) {

        if (move_no == n * n) {
            return true;
        }

        int rowDir[] = {+2, +1, -1, -2, -2, -1, +1, +2};
        int colDir[] = {+1, +2, +2, +1, -1, -2, -2, -1};

        for (int curDir = 0; curDir < 8; ++curDir) {

            int nextRow = curRow + rowDir[curDir];
            int nextCol = curCol + colDir[curDir];

            if (canPlace(board, n, nextRow, nextCol)) {
                //Place the knight
                board[nextRow][nextCol] = move_no + 1;
                boolean isSuccessful = solveKnightTour(board, n, move_no + 1, nextRow, nextCol);

                if (isSuccessful) {
                    return true;
                }

                board[nextRow][nextCol] = 0;  //erase the knight
            }
        }

        return false;
    }

    public static boolean canPlace(int[][] board, int n, int r, int c) {
        return r >= 0 && r < n
                && c >= 0 && c < n
                && board[r][c] == 0;
    }

    public static void printBoard(int board[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%-3s", board[i][j] + " "));
            }
            System.out.println();
        }
    }


}
