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
import org.hibernate.SessionFactory;
import com.dao.StudentDao;
import com.dao.SubjectDao;
import com.dto.Student;
import com.dto.Subject;
import com.util.HibernateUtil;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	StudentDao studentDao = new StudentDao();
	SubjectDao subjectDao = new SubjectDao();
	RequestDispatcher reqDispatcher;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if(session != null) {
			String action = request.getServletPath();
			if(action == "/addStudent") {
				saveStudent(request, response);
			}else 
				if(action == "/deleteStudent") {
					deleteStudent(request, response);
				}
				else 
					if(action == "/listStudents") {
						listOfStudents(request, response);
					}else if(action == "/student") {
						listOfStudents(request, response);
					}

		}else {
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("index.html");
			reqDispatcher.include(request, response);
			writer.println("<h1> Session Expired </h1>");
		}


	}

	private void saveStudent(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		Student student = new Student();
		RequestDispatcher reqDispatcher;
		String subjectName = request.getParameter("subject");
		Subject subjectObject = validateSubject(subjectName);

		if(subjectObject != null)
		{
			student.setStudentName(request.getParameter("name").toLowerCase());
			student.setStudentEmail(request.getParameter("email").toLowerCase());
			student.setSubject(subjectObject);
			studentDao.saveStudent(student);
			List<Student> listStudents = studentDao.getAllStudents();	
			request.setAttribute("listStudents", listStudents);
			reqDispatcher = request.getRequestDispatcher("student-form.jsp");
			reqDispatcher.include(request, response);
		}else
		{
			PrintWriter writer = response.getWriter();
			reqDispatcher = request.getRequestDispatcher("student-form.jsp");
			reqDispatcher.include(request, response);
			writer.println("<h1> Invalid Subject. Available courses are: Java, Flutter, C and C++.");

		}

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)throws  IOException,ServletException{
		{
			RequestDispatcher reqDispatcher;
			PrintWriter writer = response.getWriter();

			int id = Integer.parseInt(request.getParameter("id"));
			studentDao.deleteStudent(id);
			reqDispatcher = request.getRequestDispatcher("home.jsp");
			reqDispatcher.include(request, response);
			writer.println("<h1> Student deleted successfuly!");

		}
	}

	private void listOfStudents(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		List<Student> listStudents = studentDao.getAllStudents();
		request.setAttribute("listStudents", listStudents);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
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



