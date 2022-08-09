package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.SubjectDao;
import com.dto.Subject;

/**
 * Servlet implementation class SubjectController
 */
public class SubjectController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	SubjectDao subjectDao = new SubjectDao();
	RequestDispatcher reqDispatcher;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		HttpSession session = request.getSession(false);

		if(session != null) {

			String action = request.getServletPath();
			if(action == "/addSubject") {
				saveSubject(request, response);
			}else 
				if(action == "/deleteSubject") {
					deleteSubject(request, response);
				}
				else 
					if(action == "/listSubjects") {
						listOfSubjects(request, response);
					}else if(action == "/subject") {
						listOfSubjects(request, response);
					}			
		}else {
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("index.html");
			reqDispatcher.include(request, response);
			writer.println("<h1> Session Expired </h1>");
		}


	}


	private void saveSubject(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		Subject subject = new Subject();



		subject.setSubjectName(request.getParameter("name").toLowerCase());
		subject.setSubjectTime(request.getParameter("time").toLowerCase());

		subjectDao.saveSubject(subject);
		List<Subject> listSubjects = subjectDao.getAllSubjects();

		request.setAttribute("listSubjects", listSubjects);
		reqDispatcher = request.getRequestDispatcher("subject-form.jsp");
		reqDispatcher.include(request, response);




	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)throws  IOException,ServletException{
		{
			PrintWriter writer = response.getWriter();

			int id = Integer.parseInt(request.getParameter("id"));
			subjectDao.deleteSubject(id);
			List<Subject> listSubjects = subjectDao.getAllSubjects();
			request.setAttribute("listSubjects", listSubjects);
			reqDispatcher = request.getRequestDispatcher("subject-form.jsp");
			reqDispatcher.include(request, response);
			writer.println("<h1>Subject Deleted Successfuly!</h1>");


		}
	}

	private void listOfSubjects(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Subject> listSubjects = subjectDao.getAllSubjects();
		request.setAttribute("listSubjects", listSubjects);
		reqDispatcher = request.getRequestDispatcher("subject-form.jsp");
		reqDispatcher.include(request, response);
	}



}
