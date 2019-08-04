package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Course;
import com.code.hib.entity.Instructor;
import com.code.hib.entity.InstructorDetail;
import com.code.hib.entity.Review;
import com.code.hib.entity.Student;

public class CreateCoursesStudentDemo {

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
			Course tCourse =new Course("Contra game");
			
			
			System.out.println("Beforesave course");
			session.save(tCourse);
			System.out.println("save course");
			
			Student lStudent = new Student("Raj","Kumar","rk@tbd.com");
			Student lStudent1 = new Student("Raj1","Kumar","rk1@tbd.com");
			Student lStudent2 = new Student("Raj2","Kumar","rk2@tbd.com");
			
			tCourse.addStudent(lStudent);
			tCourse.addStudent(lStudent1);
			tCourse.addStudent(lStudent2);
			
			session.save(lStudent);
			session.save(lStudent1);
			session.save(lStudent2);
			
			
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
