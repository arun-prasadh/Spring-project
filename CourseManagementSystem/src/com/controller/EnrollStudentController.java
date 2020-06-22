package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Course;
import com.bean.Student;
import com.exception.StudentEnrollmentException;
import com.service.EnrollStudentService;

@Controller
public class EnrollStudentController {

	@Autowired
	EnrollStudentService service;
	
	@RequestMapping("/home.htm")
	public ModelAndView displayHomePage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	@ModelAttribute("courseList")
	public Map<String,String> populateCourse()
	{
		List<Course> courseList  = service.getCourseDetails();
		Map<String,String> courseMap  = new HashMap<String,String>();
		for(Course course :courseList)
		{
			courseMap.put(course.getCourseCode(), course.getCourseName());
			
		}
		return courseMap;
	}
	@RequestMapping("/loadEnrollpage.htm")
	public ModelAndView loadEnrollPage(ModelMap map)
	{
		ModelAndView mv = new ModelAndView();
		map.addAttribute("student", new Student());
		mv.setViewName("courseenrollment");
		return mv;
	}
	
	@RequestMapping("/enrollStudent.htm")
	public ModelAndView enrollStudent(@ModelAttribute Student student,
			BindingResult result)
	{
		ModelAndView mv = new ModelAndView();
	
		try {
			String enrollNumber  = service.enrollStudent(student);
			mv.setViewName("success");
			mv.addObject("Message", 
	"Thank you for registraion. you enrollNumber is "+enrollNumber);
		} catch (StudentEnrollmentException e) {
			e.printStackTrace();
			mv.addObject("Message", e.getMessage());
			
		}
		mv.setViewName("courseenrollment");
		return mv;
	}
	@RequestMapping("/getCourseDetailForm.htm")
	public ModelAndView getCourseDetails()
	{
		ModelAndView mv = new ModelAndView();
		List<Course> courseList  = service.getCourseDetails();
		mv.addObject("courseList", courseList);
		mv.setViewName("viewallcourse");
		return mv;
	}
}
