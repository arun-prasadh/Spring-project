package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class CourseEntity {

	@Id
	
	private String courseCode;
	
	private String courseName;
	
	private Double coursefees;
	
	private String courseType;

	public CourseEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getCoursefees() {
		return coursefees;
	}

	public void setCoursefees(Double coursefees) {
		this.coursefees = coursefees;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	
	
}
