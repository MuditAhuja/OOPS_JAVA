package com.student.dao;

import com.student.model.Student;
import com.student.exception.InvalidMarksException;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    private static final String URL  = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASS = "123456789";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void addStudent(Student s) throws InvalidMarksException, SQLException {
        if (s.getMarks() < 0 || s.getMarks() > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
        String sql = "INSERT INTO students (student_id, name, marks) VALUES (?, ?, ?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getStudentId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getMarks());
            ps.executeUpdate();
        }
    }
    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE student_id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getInt("marks")
                ));
            }
        }
        return list;
    }
}