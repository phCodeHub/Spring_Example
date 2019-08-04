package com.webtracker.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webtracker.demo.service.CustomerService;
import com.webtracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")//same as @RequestMapping for GET request-- similar @PostMapping for post request
	public String listCutomers(Model model) {
		
		List<Customer> lCustomers = customerService.getCustomers();
		System.out.println("customer list -- "+lCustomers);
		model.addAttribute("customers", lCustomers);
		
		return "list-customers";
	}

	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model lModel) {
		
		Customer lCustomer = new Customer();
		lModel.addAttribute("customer", lCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer pCustomer) {
		
		customerService.saveCustomer(pCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,Model pModel) {
		
		
		Customer customer = customerService.getCustomers(id);
		
		pModel.addAttribute("customer", customer);
		
		return "customer-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id,Model pModel) {
		
		
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	
	
	
	
	
	
	
	
	
}
