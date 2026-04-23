package com.student.servlet;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addStudent")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("studentId"));
            String name = request.getParameter("name");
            int marks = Integer.parseInt(request.getParameter("marks"));

            Student s = new Student(id, name, marks);
            StudentDAO dao = new StudentDAO();
            dao.addStudent(s);


            response.sendRedirect("displayStudents");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}