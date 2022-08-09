package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String teacherName;
	private String teacherEmail;
	@OneToOne
	private Subject subject;
	
	public Teacher() {
		
	}
	
	
	public Teacher(String teacherName, String email, Subject subject) {
		super();
		this.teacherName = teacherName;
		this.teacherEmail = email;
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String studentName) {
		this.teacherName = studentName;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String email) {
		this.teacherEmail = email;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "Teacher [id=" + id + ", studentName=" + teacherName + ", email=" + teacherEmail + ", subject=" + subject + "]";
	}
	
	
	

}
