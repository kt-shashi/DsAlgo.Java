package com.shashi.dsalgo.collectionsdemo;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        //Add
        list.add("a");
        list.add("b");
        list.add("c");
        //Add at desired given index
        list.add(0, "z");

        System.out.println(list);

        //Replace
        list.set(0, "z+");

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));       //Get value for an index

        //remove by index
        list.remove(0);

        //Index of first occurrence of an object
        //Returns -1 if not present
        int firstOccurrence = list.indexOf("a");
        //Similarly we have list.lastIndexOF("a")

        //Get a new sub list of the original list
        //From is Inclusive but To is exclusive
        System.out.println(list.subList(0, 2));

    }
}
