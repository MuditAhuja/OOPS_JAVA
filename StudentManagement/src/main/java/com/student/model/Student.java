package com.student.model;

public class Student {
    private int studentId;
    private String name;
    private int marks;

    public Student(int studentId, String name, int marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    public int getStudentId() { return studentId; }
    public String getName()   { return name; }
    public int getMarks()     { return marks; }
}