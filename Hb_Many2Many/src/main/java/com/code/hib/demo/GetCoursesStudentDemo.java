package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Course;
import com.code.hib.entity.Instructor;
import com.code.hib.entity.InstructorDetail;
import com.code.hib.entity.Review;
import com.code.hib.entity.Student;

public class GetCoursesStudentDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Course");
			int pId = 1;
			
			session.beginTransaction();
			int studentId = 2;
			
			Student tStudent = session.get(Student.class, studentId);
			
			System.out.println("Student --"+tStudent);
			System.out.println("Student Courses --"+tStudent.getCourses());
			
			
			
			
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
