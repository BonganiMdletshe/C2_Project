package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Subject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String subjectName;
	private String subjectTime;
	
	public Subject() {
		
	}
	

	public Subject(String name, String time) {
		this.subjectName = name;
		this.subjectTime = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subject) {
		this.subjectName = subject;
	}
	public String getSubjectTime() {
		return subjectTime;
	}
	public void setSubjectTime(String time) {
		this.subjectTime = time;
	}
	
	
	

}
