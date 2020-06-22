package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Course;
import com.bean.Student;
import com.entity.CourseEntity;
import com.entity.StudentEntity;

@Component
public class EnrollStudentDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public int enrollStudent(Student student) {
		StudentEntity se = new StudentEntity();
		se.setStudentName(student.getStudentName());
		se.setGender(student.getGender());
		String[] courseTypeArray = student.getCourseType();
		if (courseTypeArray.length == 1) {
			se.setCourseType(courseTypeArray[0]);
		} else if (courseTypeArray.length == 2) {
			se.setCourseType("Both");
		}
		CourseEntity ce = 
				em.find(CourseEntity.class, student.getCourseCode());
		se.setCourse(ce);
		em.persist(se);
		int enrollNumber  = se.getEnrollNumber();
		return enrollNumber;
	}
	
	public String reteriveCourseType(String courseCode)
	{
		CourseEntity ce  = em.find(CourseEntity.class, courseCode);
		String courseType  = ce.getCourseType();
		return courseType;
	}
	
	public List<Course> getCourseDetails()
	{
		Query query  =  em.createQuery("from CourseEntity c");
		List<CourseEntity> courseList  = query.getResultList();
		List<Course> clist = new ArrayList<Course>();
		for(CourseEntity c :courseList)
		{
			Course course  = new Course();
			course.setCourseCode(c.getCourseCode());
			course.setCourseName(c.getCourseName());
			course.setCourseFees(c.getCoursefees());
			course.setCourseType(new String[] {c.getCourseType()});
			clist.add(course);
		}
		
		return clist;
	}
	
}
