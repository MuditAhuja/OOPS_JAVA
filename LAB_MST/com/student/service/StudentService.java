package com.student.service;

import com.student.model.Student;
import java.io.*;

public class StudentService {

    public void addStudent(Student s) throws InvalidMarksException {

        if (s.marks < 0 || s.marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }

        try {
            FileWriter fw = new FileWriter("students.txt", true);
            fw.write(s.studentId + " " + s.name + " " + s.marks + "\n");
            fw.close();

            System.out.println("Student added");

        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void displayStudents() {

        try {
            FileReader fr = new FileReader("students.txt");

            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

            fr.close();

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}