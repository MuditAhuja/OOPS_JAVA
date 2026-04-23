package com.student.servlet;

import com.student.dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            StudentDAO dao = new StudentDAO();
            dao.deleteStudent(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("displayStudents");
    }
}