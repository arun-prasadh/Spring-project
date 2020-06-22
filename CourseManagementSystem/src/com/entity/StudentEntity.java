package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "enrollstudent")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enrollNumber;

	private String studentName;

	private String gender;

	private String courseType;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coursecode")
	private CourseEntity course;

	public StudentEntity() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEnrollNumber() {
		return enrollNumber;
	}

	public void setEnrollNumber(Integer enrollNumber) {
		this.enrollNumber = enrollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

}
