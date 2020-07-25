package com.shashi.dsalgo.hashdemo;

public class LinearProbeHashTable {

    private static String[] valuesTable;
    private static int[] keysTable;

    public LinearProbeHashTable(int size) {
        valuesTable = new String[size];
        keysTable = new int[size];
    }

    //Returns index of a key
    private static int hashFunction(int key) {
        return key % keysTable.length;
    }

    //Find the hash value of the key
    //Case 1: The index is empty:
    //Place the value
    //Case 2: The index is occupied
    //Find the next empty position and place thw value
    public static void insert(int key, String value) {

        int hashValue = hashFunction(key);

        if (valuesTable[hashValue] == null) {
            valuesTable[hashValue] = value;
            keysTable[hashValue] = key;
        } else {

            do {
                hashValue = (hashValue + 1) % valuesTable.length;
            } while (valuesTable[hashValue] != null && valuesTable[hashValue].compareTo(value) != 0);

            if (valuesTable[hashValue].compareTo(value) != 0) {
                valuesTable[hashValue] = value;
                keysTable[hashValue] = key;
            }
        }

    }

    public static void printValues() {
        for (int i : keysTable) {
            int hashValue = hashFunction(i);
            String data = valuesTable[hashValue];

            System.out.println("Key: " + i + " -> Value: " + data);
        }
    }

    public static void main(String[] args) {
        LinearProbeHashTable table = new LinearProbeHashTable(5);
        insert(2, "Man1");
        insert(2, "Man2");
        insert(6, "Man6");
        insert(4, "Man4");
        printValues();
    }

    //Find a key:
    //Generate it's hashValue
    //Case 1: The element is null
    //If element is null, return
    //Case 2: Element is present
    public static int find(int key) {
        int hashValue = hashFunction(key);
        return 0;
    }

}
