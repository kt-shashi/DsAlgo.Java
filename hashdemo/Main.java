package com.shashi.dsalgo.hashdemo;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        SimpleHashTable ht = new SimpleHashTable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        System.out.println("Print HashTable\n");
        ht.printHashTable();


        System.out.println("Retrieve Mary: " + ht.get("Smith"));

        ht.remove("Wilson");
        ht.remove("Jones");

        System.out.println("Removed: Mike Wilson and Jane Jones");
        ht.printHashTable();
    }
}
