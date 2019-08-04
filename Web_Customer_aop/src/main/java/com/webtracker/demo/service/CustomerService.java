package com.webtracker.demo.service;

import java.util.List;

import com.webtracker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer pCustomer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);

}
