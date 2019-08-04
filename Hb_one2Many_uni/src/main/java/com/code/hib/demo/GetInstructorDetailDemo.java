package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Instructor;
import com.code.hib.entity.InstructorDetail;
import com.code.hib.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Instructor");
						
			session.beginTransaction();
			int id = 2;
			
			InstructorDetail instDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("ins detail "+instDetail);
			
			System.out.println("instructor "+instDetail.getInstructor());
			
			
			session.delete(instDetail);
			
			session.getTransaction().commit();
			System.out.println("After Commit");
			
		}
		catch(Exception e) {
			
		}
		finally {
			factory.close();
		}

	}

}
