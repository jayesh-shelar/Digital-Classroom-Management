package com.touchcore.classroom;

public class Student
{
	private String firstName;
	private String lastName;
	private String email;
	private int courseId;
	
	public Student()
	{
		super();
	}

	public Student(String firstName, String lastName, String email, int courseId)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseId = courseId;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public int getCourseId() 
	{
		return courseId;
	}

	public void setCourseId(int courseId) 
	{
		this.courseId = courseId;
	}
}
