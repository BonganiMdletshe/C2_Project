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
 * Servlet implementation class ClassesController
 */
public class ClassesController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if(session != null) {

			int resultId = validateSubject(request, response);

			if(resultId != 0) {
				request.setAttribute("resultId", resultId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("classes-list.jsp");
				dispatcher.include(request, response);

			}else {
				PrintWriter writer = response.getWriter();
				request.setAttribute("resultId", resultId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("classes-form.jsp");
				dispatcher.include(request, response);
				writer.println("<h1>Error! No classes found for the selected subject.");
				writer.println("<h2>Please enter a different subject </h2>.");
			}
		}
		else if(session == null){

			RequestDispatcher reqDispatcher;
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("index.html");
			reqDispatcher.include(request, response);
			writer.println("<h1> Session Expired </h1>");
		}




	}

	private int validateSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int resultId = 0;

		if(request.getParameter("subject").toLowerCase().equals("java")){
			resultId = 1;
		}else 
			if(request.getParameter("subject").toLowerCase().equals("c")){
				resultId = 2;
			}else 
				if(request.getParameter("subject").toLowerCase().equals("c++") ){
					resultId = 3;
				}else if(request.getParameter("subject").toLowerCase().equals("flutter")){
					resultId = 4; 
				}


		return resultId;
	}

}
