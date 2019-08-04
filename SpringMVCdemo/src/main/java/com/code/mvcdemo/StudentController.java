package com.code.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model lModel) {
		
		//Create student
		Student lStudent = new Student();
		
		lModel.addAttribute("student", lStudent);
		
		//add to Model
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student pStudent) {
		
		System.out.println("student data "+pStudent.getFirstName()+" "+pStudent.getLastName());
		return "student-confirm";
		
	}

}
