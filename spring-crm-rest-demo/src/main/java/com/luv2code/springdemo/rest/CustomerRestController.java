package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")

public class CustomerRestController {
	
	//autowire customer service
	@Autowired
	CustomerService lCustomerService;
	
	
	//add mapping to get customer
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return lCustomerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId){
		
		Customer lCustomer =  lCustomerService.getCustomer(customerId);
		
		if (lCustomer == null)
			throw new CustomerNotFoundException("Customer Not found -->");
		
		return lCustomer;
	}
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer tCustomer) {
		
		tCustomer.setId(0);
		
		lCustomerService.saveCustomer(tCustomer);
		
		return tCustomer;
		
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer tCustomer) {
		
		lCustomerService.saveCustomer(tCustomer);
		
		return tCustomer;
		
	}
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomers(@PathVariable int customerId){
		
		Customer lCustomer =  lCustomerService.getCustomer(customerId);
		
		if (lCustomer == null)
			throw new CustomerNotFoundException("Customer Not found -->");
		
		lCustomerService.deleteCustomer(customerId);
		
				
		return "Customer Deleted";
	}

}
