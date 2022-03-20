package com.touchcore.classroom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
	private static Connection con = null;

	static
	{
		String dbUrl = "jdbc:mysql://localhost:3306/classroom";
		String dbUsername = "root";
		String dbPassword = "12345678";
		String dbDriver = "com.mysql.cj.jdbc.Driver";

		try
		{
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		return con;
	}
}
