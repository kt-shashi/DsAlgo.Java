package com.shashi.dsalgo.hashdemo;

import javax.swing.*;

public class SimpleHashTable {

    private StoredEmployee[] hashtable;

    //Constructor to initialize the array
    public SimpleHashTable() {
        hashtable = new StoredEmployee[10];

    }

    //insert
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);

        //linear probing
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;        //if we are in the last index, then loop
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        //if linear probing is done, it will come here and add the element in else block, otherwise
        //it will not add the item using if block
        if (hashtable[hashedKey] != null) {
            System.out.println("Position: " + hashedKey + " already in use");
        } else {
            hashtable[hashedKey] = new StoredEmployee(key, employee);
        }
    }

    //retrieve
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    //Remove
    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        return employee;
    }


    //Find Key
    private int findKey(String key) {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        //if not found then try finding using Linear Probing
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;        //if we are in the last index, then loop
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null &&
                hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }


    }

    //Hash Function
    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    //print
    public void printHashTable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null)
                System.out.println("Index: " + i + " is null");
            else {
                System.out.println("Index: " + i + " " + hashtable[i].employee.getFirstName() + " " + hashtable[i].employee.getLastName());
            }
        }
    }

    //check if index is already occupied
    private boolean occupied(int index) {
        return hashtable[index] != null;
    }
}
