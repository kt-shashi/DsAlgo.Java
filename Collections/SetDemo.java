package com.shashi.dsalgo;

import java.util.*;

public class SetDemo {

    public static void main(String[] args) {

        //Guarantees unique elements but order is not preserved
        Set<String> set = new HashSet<>();
        set.add("sky");
        set.add("is");
        set.add("blue");
        set.add("blue");

        System.out.println(set);

        //Remove duplicates
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "a", "b", "c", "d", "c");

        Set<String> set2 = new HashSet<>(collection);
        System.out.println(set2);

        //Pass some values as list
        Set<String> set3 = new HashSet<>(Arrays.asList("a", "b", "c"));

        Set<String> set4 = new HashSet<>(Arrays.asList("b", "c", "d"));

        //Union
        set3.addAll(set4);
        //Intersection
        set3.retainAll(set4);
        //Difference
        set3.retainAll(set4);

    }
}
