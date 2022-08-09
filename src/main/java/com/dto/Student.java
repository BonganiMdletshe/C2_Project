package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String studentName;
	private String studentEmail;
	@OneToOne
	private Subject studentSubject;
	
	public Student() {
		
	}
	
	public Student(String studentName, String email, Subject subject) {
		super();
		this.studentName = studentName;
		this.studentEmail = email;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return studentSubject;
	}

	public void setSubject(Subject subject) {
		this.studentSubject = subject;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String email) {
		this.studentEmail = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", email=" + studentEmail + ", subject=]";
	}




	
	
	

}
