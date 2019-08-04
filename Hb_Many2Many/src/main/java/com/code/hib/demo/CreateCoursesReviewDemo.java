package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Course;
import com.code.hib.entity.Instructor;
import com.code.hib.entity.InstructorDetail;
import com.code.hib.entity.Review;
import com.code.hib.entity.Student;

public class CreateCoursesReviewDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Course");
			int pId = 1;
			
			session.beginTransaction();
			Course tCourse =new Course("Contra game");
			tCourse.addReview(new Review("Good game"));
			tCourse.addReview(new Review("Good game....play"));
			tCourse.addReview(new Review("Good game...must play"));
			
			System.out.println("Beforesave course");
			session.save(tCourse);
			
			
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
