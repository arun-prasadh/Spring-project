package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.Course;
import com.bean.Student;
import com.dao.EnrollStudentDAO;
import com.exception.StudentEnrollmentException;

@Component
public class EnrollStudentService {

	@Autowired
	EnrollStudentDAO dao;
	
	public String enrollStudent(Student student) throws StudentEnrollmentException
	{
	
		String courseType = dao.reteriveCourseType(student.getCourseCode());
		
		String[] courseTypeArray  = student.getCourseType();
		
		if(!(courseType.equals("Both")))
		{
			if((courseTypeArray.length==2))
			{
				throw new StudentEnrollmentException();
			}
			
			if((courseTypeArray.length==1)&&
					(!(courseType.equals(courseTypeArray[0]))))
			{
				throw new StudentEnrollmentException();
			}
		}
		
		Integer enrollNumber  = dao.enrollStudent(student);
		
		return enrollNumber.toString();
	}
	
	public List<Course> getCourseDetails()
	{
		List<Course> courseList  = dao.getCourseDetails();
		return courseList;
	}
}
