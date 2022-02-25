package com.zensar.thymeleafdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zensar.thymeleafdemo.entity.Student;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@GetMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav=new ModelAndView("getData");
		Student student=new Student();
		student.setStudentId(1001);
		student.setStudentName("Rama");
		mav.addObject("student", student);
		return mav;
	}

}
