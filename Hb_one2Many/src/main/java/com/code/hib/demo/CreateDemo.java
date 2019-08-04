package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Instructor;
import com.code.hib.entity.InstructorDetail;
import com.code.hib.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Instructor");
			/*Instructor tInstructor = new Instructor("Pulkit","Singh","td@ref.com");
			InstructorDetail tInstructorDetail =new InstructorDetail("www.codegyan.com","codinggg");
			*/
			Instructor tInstructor = new Instructor("Deep","Gupta","deep@ref.com");
			InstructorDetail tInstructorDetail =new InstructorDetail("www.deepgyan.com","selling");
			
			
			Instructor pInstructor = new Instructor("Pintu","Kundu","pintu@ref.com");
			InstructorDetail pInstructorDetail =new InstructorDetail("www.pintugyan.com","khanp");
			
			
			tInstructor.setInstructorDetail(tInstructorDetail);
			pInstructor.setInstructorDetail(pInstructorDetail);
			
			session.beginTransaction();
			System.out.println("About save");
			// it will save Instructor and detail both as cascade.all is set
			session.save(tInstructor);
			session.save(pInstructor);
			
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
