package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Course;
import com.code.hib.entity.Instructor;
import com.code.hib.entity.InstructorDetail;
import com.code.hib.entity.Student;

public class CreateCoursesDemo {

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
			
			session.beginTransaction();
			Instructor pInstructor=session.get(Instructor.class, pId);
			System.out.println("About save");
			Course pCourse = new Course("Java coding");
			Course pCourse1 = new Course("Spring");
			
			pInstructor.addCourse(pCourse1);
			pInstructor.addCourse(pCourse);
			
			session.save(pCourse);
			session.save(pCourse1);
			
			session.getTransaction().commit();
			System.out.println("After Commit");
			
		}
		catch(Exception e) {
			
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
