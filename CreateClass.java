package com.touchcore.classroom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateClass")
public class CreateClass extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String courseName = request.getParameter("courseName");
		
		Course course = new Course(courseName);
		
		CourseDao courseDao = new CourseDao();
		
		courseDao.insertData(course);
		
		response.sendRedirect("teacher.jsp");	
	}
}
