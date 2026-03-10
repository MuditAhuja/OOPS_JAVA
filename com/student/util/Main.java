package com.student.util;

import com.student.model.Student;
import com.student.service.StudentService;
import com.student.service.InvalidMarksException;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        Student s1 = new Student(1, "Ram", 80);
        Student s2 = new Student(2, "Riya", 90);
        Student s3 = new Student(3, "Aman", 120);

        try {

            service.addStudent(s1);
            service.addStudent(s2);
            service.addStudent(s3);

        } catch (InvalidMarksException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Student List:");

        service.displayStudents();
    }
}