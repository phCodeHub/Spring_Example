package com.webtracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webtracker.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Inject SessionFactory
	@Autowired
	private SessionFactory sessionFactory;
	
	//@Transactional // automatically begin and commit transaction- aded at service layer
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		
		Query<Customer> lQuery = session.createQuery("From Customer order by lastName", Customer.class);
		
		
		List<Customer> customerList = lQuery.getResultList();
		
		
		return customerList;
	}

	@Override
	public void saveCustomer(Customer pCustomer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
	//	session.save(pCustomer);
		
		session.saveOrUpdate(pCustomer);
		
	}

	@Override
	public Customer getCustomers(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer lCustomer = session.get(Customer.class, id);
		return lCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
			Session session = sessionFactory.getCurrentSession();
		
		//	session.save(pCustomer);
			
			Query query = session.createQuery("delete from Customer where id = :id");
			query.setParameter("id", id);
			
			query.executeUpdate();
			
			
		
	}

}
