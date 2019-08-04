package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.code.hib.entity.Course;
import com.code.hib.entity.Instructor;
import com.code.hib.entity.InstructorDetail;

public class FetchJOinDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Course");
			int pId = 1;
			
			//Hibernate query with hQL
			
			session.beginTransaction();
			//Instructor pInstructor=session.get(Instructor.class, pId);
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+"JOIN FETCH i.courses where i.id = :theInstructorId", Instructor.class);
			
			query.setParameter("theInstructorId", pId);
			
			Instructor pInstructor = query.getSingleResult();
			
			System.out.println("Instructor-->"+pInstructor);
			
			//System.out.println("list of courses-->"+pInstructor.getCourses());
			
			session.getTransaction().commit();
			System.out.println("After Commit");
			session.close();
			
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
