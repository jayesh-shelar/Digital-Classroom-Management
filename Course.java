package com.touchcore.classroom;

public class Course
{
	private String courseName;
	
	public Course(String courseName)
	{
		super();
		this.courseName = courseName;
	}

	public Course()
	{
		super();
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
}
