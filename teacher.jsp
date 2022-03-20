<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.touchcore.classroom.Database"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Workspace</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>
<div>
        <h2 style="background-color: black; color: white; text-align: center; padding: 3px;">Digital Classroom Management: Teacher Workspace</h2>
    </div>
    <div class="boxes">
        <fieldset style = "margin: 20px; border: 3px solid black;">
            <legend>
                <h3>Create New Class</h3>
            </legend>
            <form action="CreateClass" method="post" onsubmit="alert1()" style="text-align: center;">
                <label for="coureName">Course Name</label>
                <input type="text" name="courseName" required maxlength="45">
                <input type="submit" value="Create Class"
                    style="background-color: #1c92d2; color: white; cursor: pointer; border-color: black;">
            </form>
        </fieldset>
    </div>
    <div class="boxes">
        <fieldset style = "margin: 20px; border: 3px solid black;">
            <legend>
                <h3>Add Student to Class</h3>
            </legend>
            <center>
                <table cellpadding="8">
                    <form action="AddStudent" method="post" onsubmit="alert2()">
                    <tr>
                        <td><label for="firstName">First Name</label></td>
                        <td><input type="text" name="firstName" required maxlength="45"
                                oninput="this.value = this.value.replace(/[^a-zA-Z.]/,'')"></td>
                    </tr>
                    <tr>
                        <td><label for="lastName">Last Name</label></td>
                        <td><input type="text" name="lastName" required maxlength="45"
                                oninput="this.value = this.value.replace(/[^a-zA-Z.]/,'')"></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input type="email" name="email" required></td>
                    </tr>
                    <tr>
                        <td><label for="courseId">Course ID</label></td>
                        <td><input type="number" name="courseId" required></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;"><input type="submit" value="Add Student"
                                style="background-color: #1c92d2; color: white; cursor: pointer; border-color: black;">
                        </td>
                    </tr>
                    </form>
                </table>
            </center>
        </fieldset>
    </div>
    <div class="boxes">
        <fieldset style = "margin: 20px; border: 3px solid black;">
            <legend>
                <h3>Upload Document to Class</h3>
            </legend>
            <center>
                <table cellpadding="8">
                    <form action="UploadDocument" method="post" onsubmit="alert3()">
                    <tr>
                        <td><label for="document">Select Document</label></td>
                        <td><input type="file" name="file" required></td>
                    </tr>
                    <tr>
                        <td><label for="courseId">Course ID</label></td>
                        <td><input type="number" name="courseId" required></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;"><input type="submit" value="Upload Document"
                                style="background-color: #1c92d2; color: white; cursor: pointer; border-color: black;">
                        </td>
                    </tr>
                    </form>
                </table>
            </center>
        </fieldset>
    </div>
    <div class="boxes">
        <fieldset style = "margin: 20px; border: 3px solid black;">
            <legend>
                <h3>List of Classes</h3>
            </legend>
            <center>
                <table border="1" cellspacing="0" cellpadding="8">
                    <tr>
                        <th>Course ID</th>
                        <th>Class Name</th>
                    </tr>
                   <% 
						Connection con = Database.getConnection();
				        String sql = "select * from course";
				
						try 
						{
							PreparedStatement ps = con.prepareStatement(sql);
							ResultSet rs = ps.executeQuery();
							while(rs.next())
					        {
				    %>				<tr>
				        				<td><%= rs.getString("courseId")%></td>
				        				<td><%= rs.getString("courseName")%></td>
				        			</tr>
				    <%      }
						}
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
				    %>
                </table>
            </center>
        </fieldset>
    </div>
    <script>
        function alert1()
        {
            window.alert("New class created successfully!");
        }

        function alert2()
        {
            window.alert("Student added to class successfully!");
        }

        function alert3()
        {
            window.alert("Document uploaded successfully!");
        }
    </script>
</body>
</html>