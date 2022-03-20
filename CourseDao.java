package com.touchcore.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDao
{
	public void insertData(Course course)
	{
		Connection con = Database.getConnection();
		
		String sql = "insert into course(courseName) values(?)";
		
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course.getCourseName());
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
