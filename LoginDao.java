package com.touchcore.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao
{
	public boolean validate(User user)
	{
		Connection con = Database.getConnection();
		String sql = "select * from user where email = ? and password = ? and role = ?";
		boolean flag = false;

		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ResultSet rs = ps.executeQuery();
			flag = rs.next();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return flag;
	}
}
