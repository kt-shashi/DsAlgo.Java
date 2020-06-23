package com.shashi.dsalgo;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        List<Student> students = new ArrayList<>();

        students.add(new Student("Lmao", 20));
        students.add(new Student("Lel", 55));
        students.add(new Student("Chikapu", 34));
        students.add(new Student("Chikapu22", 3));
        students.add(new Student("Xdd", 86));
        students.add(new Student("Xdd", 87));
        students.add(new Student("Ok Boomer", 74));

        Collections.sort(students, new SortByNameThenMarks());

        for (Student student : students)
            System.out.println(student);
    }
}

class SortByNameThenMarks implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.name.equals(o2.name)) {
            return o1.marks - o2.marks;
        }
        else {
            return o1.name.compareTo(o2.name);
        }
    }
}