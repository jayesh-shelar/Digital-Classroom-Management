package com.touchcore.classroom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int courseId = Integer.valueOf(request.getParameter("courseId"));
		
		Student student = new Student(firstName, lastName, email, courseId);
		
		StudentDao studentDao = new StudentDao();
		
		studentDao.insertData(student);
		
		response.sendRedirect("teacher.jsp");
	}
}
