package com.webtracker.dao;

import java.util.List;

import com.webtracker.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer pCustomer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);

}
