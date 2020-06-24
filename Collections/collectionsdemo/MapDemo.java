package com.shashi.dsalgo.collectionsdemo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        //Add element in Map
        map.put("email1", "A");
        map.put("email2", "B");
        map.put("email3", "C");
        map.put("email4", "D");

        //Get value from a key
        String string1 = map.get("email1");
        System.out.println(string1);

        //Check if present
        Boolean b1 = map.containsKey("email45");

        //Replace an object
        map.replace("email4", "Z");
        System.out.println(map);

        //Can be directly used in for each loop
        for (String key : map.keySet())
            System.out.println(key);

        //if you want to get key and value use entry set
        for (Map.Entry<String, String> set : map.entrySet()) {
            System.out.println(set);
            set.getKey();
            set.getValue();
        }

        for (String customers : map.values())
            System.out.println(customers);

    }
}
