package com.shashi.dsalgo;
//implements Comparable<Student>

public class Student{
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student [marks=" + marks + ", name=" + name + "]";
    }


//    @Override
//    public int compareTo(Student o) {
//        if(this.marks > o.marks)    return 1;
//        else if(this.marks < o.marks)   return -1;
//        return 0;
//    }
}


