<%@ page contentType="text/html" import="java.util.*, com.student.model.Student" %>
<html>
<head><title>Student List</title></head>
<body>
  <h2>All Students</h2>
  <% String err = (String) request.getAttribute("error");
     if (err != null) { %>
    <p style="color:red;"><%= err %></p>
  <% } else {
       List<Student> students = (List<Student>) request.getAttribute("students"); %>
    <table border="1" cellpadding="8">
      <tr><th>ID</th><th>Name</th><th>Marks</th></tr>
      <% for (Student s : students) { %>
        <tr>
          <td><%= s.getStudentId() %></td>
          <td><%= s.getName() %></td>
          <td><%= s.getMarks() %></td>
        </tr>
      <% } %>
    </table>
  <% } %>
  <br><a href="index.jsp">Back</a>
</body>
</html>