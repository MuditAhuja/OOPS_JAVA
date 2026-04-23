<%@ page contentType="text/html" %>
<html>
<head><title>Add Student</title></head>
<body>
  <h2>Add Student</h2>
  <% String msg = (String) request.getAttribute("message");
     if (msg != null) { %>
    <p><%= msg %></p>
  <% } %>
  <form action="AddStudentServlet" method="post">
    Student ID: <input type="number" name="studentId" required/><br><br>
    Name:       <input type="text"   name="name"      required/><br><br>
    Marks:      <input type="number" name="marks"      required/><br><br>
    <input type="submit" value="Add Student"/>
  </form>
  <br><a href="index.jsp">Back</a>
</body>
</html>