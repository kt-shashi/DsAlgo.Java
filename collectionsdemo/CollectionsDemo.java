package com.shashi.dsalgo.collectionsdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("a");                    //Add 1 element
        Collections.addAll(collection, "b", "c", "d"); //Add multiple elements

        collection.remove("a");        //remove 1 object
//        collection.clear();             //remove all

        boolean containsA = collection.contains("a"); //Check if contains an object

        String[] stringArray = collection.toArray(new String[0]);     //Covert to array

        Collection<String> collection2 = new ArrayList<>();
        collection2.addAll(collection);

        //Check for equal
        System.out.println(collection.equals(collection2));

        for (String s : collection) {              //Print
            System.out.println(s);
        }

        System.out.println(collection);
    }

}
