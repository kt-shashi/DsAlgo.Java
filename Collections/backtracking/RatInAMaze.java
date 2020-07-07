package com.shashi.dsalgo.backtracking;

//Make a boolean array
//If we can move, then make the boolean array as true
//recursively move up down left and right

//You can move if:
//you are Inside the maze
//the element of the original array is 1

public class RatInAMaze {

    public static void main(String[] args) {
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};

        ratInMaze(maze, 4);
    }

    static void ratInMaze(int maze[][], int n) {

        boolean[][] solution = new boolean[n][n];
        mazeHelp(maze, n, solution, 0, 0);

    }

    static void mazeHelp(int[][] maze, int n, boolean[][] solution, int x, int y) {

        //Check if we can move or not
        //if we cean move, then mark the position where we are moving,
        //and recursively move to other possible directions
        //backtrack and mark the position as false, so we can revisit via other path

        //If reached the end, then print
        if (x == n - 1 && y == n - 1) {
            printSolution(solution, n);
            return;
        }

        //Check if we can move
        if (!isSafe(maze, n, solution, x, y)) {
            return;
        }

        solution[x][y] = true;

        //Move up down left right
        mazeHelp(maze, n, solution, x - 1, y);
        mazeHelp(maze, n, solution, x + 1, y);
        mazeHelp(maze, n, solution, x, y - 1);
        mazeHelp(maze, n, solution, x, y + 1);

        solution[x][y] = false;
    }

    //Utility function to check if the x,y is valid position for N*N maze
    static boolean isSafe(int maze[][], int n, boolean[][] solution, int x, int y) {

        //If x and y are inside the maze
        //maze[x][y] is 1 and solution[x][y] is false, i.e. not visited

        if (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1 && solution[x][y] == false)
            return true;
        else
            return false;
    }

    //Utility function to print the Solution matrix
    static void printSolution(boolean sol[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sol[i][j])
                    System.out.print(" 1 ");
                else
                    System.out.print(" 0 ");
            }
            System.out.println();
        }
    }
}