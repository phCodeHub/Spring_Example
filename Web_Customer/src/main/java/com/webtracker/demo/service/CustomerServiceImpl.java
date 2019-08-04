package com.webtracker.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webtracker.dao.CustomerDAO;
import com.webtracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerDAO lCustomerDao;

	@Override
	@Transactional // automatically begin and commit transaction
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return lCustomerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer pCustomer) {
		// TODO Auto-generated method stub
		
		lCustomerDao.saveCustomer(pCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int id) {
		// TODO Auto-generated method stub
		return lCustomerDao.getCustomers(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		lCustomerDao.deleteCustomer(id);
	}

}
