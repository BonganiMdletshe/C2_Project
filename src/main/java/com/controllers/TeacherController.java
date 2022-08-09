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
import com.dao.TeacherDao;
import com.dto.Subject;
import com.dto.Teacher;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherDao teacherDao = new TeacherDao();
	SubjectDao subjectDao = new SubjectDao();
	RequestDispatcher reqDispatcher;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		HttpSession session = request.getSession(false);

		if(session != null) {

			String action = request.getServletPath();
			if(action == "/addTeacher") {

				saveTeacher(request, response);


			}else 
				if(action == "/deleteTeacher") {
					deleteTeacher(request, response);
				}
				else 
					if(action == "/listTeachers") {
						listOfTeachers(request, response);
					}else if(action == "/teacher") {
						listOfTeachers(request, response);
					}
		}else {
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("index.html");
			reqDispatcher.include(request, response);
			writer.println("<h1> Session Expired </h1>");
		}

	}

	private void saveTeacher(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		Teacher teacher = new Teacher();
		RequestDispatcher reqDispatcher;

		String subjectName = request.getParameter("subject");
		Subject subjectObject = validateSubject(subjectName);

		if(subjectObject != null)
		{

			teacher.setTeacherName(request.getParameter("name").toLowerCase());
			teacher.setTeacherEmail(request.getParameter("email").toLowerCase());
			teacher.setSubject(subjectObject);
			teacherDao.saveTeacher(teacher);
			List<Teacher> listTeachers = teacherDao.getAllTeachers();	
			request.setAttribute("listTeachers", listTeachers);
			reqDispatcher = request.getRequestDispatcher("teacher-form.jsp");
			reqDispatcher.include(request, response);
		}else
		{
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("teacher-form.jsp");
			reqDispatcher.include(request, response);
			writer.println("<h1> Invalid Subject. Available Subjects are: Java, Flutter, C and C++.");

		}

	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)throws  IOException,ServletException{
		{
			RequestDispatcher reqDispatcher;

			int id = Integer.parseInt(request.getParameter("id"));
			teacherDao.deleteTeacher(id);
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("home.jsp");
			reqDispatcher.include(request, response);
			writer.println("<h1>Teacher deleted successfuly!");
		}
	}

	private void listOfTeachers(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Teacher> listTeachers = teacherDao.getAllTeachers();
		request.setAttribute("listTeachers", listTeachers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
		dispatcher.include(request, response);
	}


	private Subject validateSubject(String subject) {

		List<Subject> listSubjects = subjectDao.getAllSubjects();
		Subject validSubject = null;

		for(Subject item: listSubjects) {

			if(item.getSubjectName().equals(subject)) {
				validSubject = item;
			}
		}
		return validSubject;


	}


}
