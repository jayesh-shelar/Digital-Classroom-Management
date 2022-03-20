package com.touchcore.classroom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		User user = new User(email, password, role);

		LoginDao loginDao = new LoginDao();

		if (loginDao.validate(user))
		{
			if (role.equals("teacher"))
			{
				response.sendRedirect("teacher.jsp");
			}
			else
			{
				request.setAttribute("user", user);
				request.getRequestDispatcher("student.jsp").forward(request, response);
			}
		}
		else
		{
			response.sendRedirect("index.html");
		}
	}
}
