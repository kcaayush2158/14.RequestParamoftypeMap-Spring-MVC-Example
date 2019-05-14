package com.application.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.model.Student;

@Controller
@RequestMapping(value="/")
public class HomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		return "register";
	}
	
	@RequestMapping(value="/registerSuccess")
	public ModelAndView registerSuccess(@RequestParam Map<String,String> requestMap) {
		Student student = new Student(requestMap.get("name"),Integer.parseInt(requestMap.get("age")),requestMap.get("email"),requestMap.get("country"));
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("user",student);
		
		return modelAndView;
	}
	
}
