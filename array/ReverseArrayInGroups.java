package com.shashi.dsalgo.array;

import java.util.ArrayList;

public class ReverseArrayInGroups {

    public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        // add your code here
        for (int i = 0; i < mv.size(); ) {
            if (i + k > mv.size()) {
                mv = reverse(mv, i, mv.size());
                break;
            }
            reverse(mv, i, i + k);
            i += k;
        }
        return mv;
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> mv, int i, int j) {
        --j;
        while (i < j) {
            int temp = mv.get(i);
            mv.set(i, mv.get(j));
            mv.set(j, temp);
            --j;
            ++i;
        }
        return mv;
    }

    public static void main(String[] args) {
        ArrayList<Integer> mv = new ArrayList<>();
        mv.add(10);
        mv.add(20);
        mv.add(30);
        mv.add(40);
        mv.add(50);
        mv.add(60);
        mv.add(70);
        mv.add(80);
        System.out.println(mv);
        mv = reverseInGroups(mv, 8, 3);
        System.out.println(mv);
    }

    public int majorityWins(int arr[], int n, int x, int y) {
        int count_x = 0;//counter to count frequency of x
        int count_y = 0;//counter to count frequency of y

        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                count_x++;
            if (arr[i] == y)
                count_y++;
        }

        if (count_x > count_y)
            return x;
        else if (count_x < count_y)
            return y;
        else {
            if (x > y)
                return x;
            else return y;
        }

    }

}
