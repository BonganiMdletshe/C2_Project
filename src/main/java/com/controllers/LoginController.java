package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.setMaxInactiveInterval(600);
		
		RequestDispatcher reqDispatcher = null;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(username.equalsIgnoreCase("b") && password.equalsIgnoreCase("123")) {
			reqDispatcher = request.getRequestDispatcher("home.jsp");
			reqDispatcher.forward(request, response);
		}else {
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("index.html");
			reqDispatcher.include(request, response);
			writer.println("<h1> Sorry...Wrong Credentials!!!!");		
		}
		
	}

	

}
