package com.code.mvcdemo;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model pModel) {
		pModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer pCustomer,BindingResult pBindingResult) {
		
		System.out.println("last name "+pCustomer.getLastName());
		System.out.println("Binding--"+pBindingResult);
		if(pBindingResult.hasErrors()) {
			System.out.println("error hai");
			return "customer-form";
		}
		return "customer-confirm";
	}
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		StringTrimmerEditor stb = new StringTrimmerEditor(true);
		wdb.registerCustomEditor(String.class, stb);
	}
}
