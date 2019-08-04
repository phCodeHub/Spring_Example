package com.code.mvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Hello")
public class HelloWorldController {
	
	//show form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloWorld-form";
	}
	
	//process form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new method to read and add data
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest request,Model model) {
		
		String theName = request.getParameter("studentName");
		
		String result = "WOW!! "+theName.toUpperCase();
		
		model.addAttribute("message", result);
		return "helloworld";
	}

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,Model model) {
		
		//String theName = request.getParameter("studentName");
		
		String result = "WOW WAA!! "+theName.toUpperCase();
		
		model.addAttribute("message", result);
		return "helloworld";
	}

}
