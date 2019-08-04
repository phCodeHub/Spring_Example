package com.code.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//Logger log = Logger.getLogger(HomeController.class.getName());
	
	@RequestMapping(value= {"","/","/myapp"})
	public String showPage()
	{
		//log.error("Inside Controller");
		System.out.println("In Home Controller");
		return "main-menu";
	}

}
