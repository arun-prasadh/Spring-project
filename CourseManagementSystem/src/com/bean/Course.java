package com.bean;

public class Course {

	private String courseCode;
	private String courseName;
	private Double courseFees;
	private String[] courseType;
	
	
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
	public Double getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(Double courseFees) {
		this.courseFees = courseFees;
	}
	public String[] getCourseType() {
		return courseType;
	}
	public void setCourseType(String[] courseType) {
		this.courseType = courseType;
	}

}
