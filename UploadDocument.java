package com.touchcore.classroom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadDocument")
public class UploadDocument extends HttpServlet 
{
	private static final long serialVersionUID = 1L;	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int courseId = Integer.valueOf(request.getParameter("courseId"));
		String file = request.getParameter("file");
		Path path = Paths.get(file);
		byte[] arr = Files.readAllBytes(path);
		
		String sql = "insert into document(document, courseId) values(?, ?)";
		
		Connection con = Database.getConnection();
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBytes(1, arr);
			ps.setInt(2, courseId);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		response.sendRedirect("teacher.jsp");
	}
}
