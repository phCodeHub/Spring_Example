package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Student");
			Student lStudent = new Student("JUn","Kebaba","tbd@xyz.com");
			
			session.beginTransaction();
			System.out.println("About save");
			session.save(lStudent);
			
			session.getTransaction().commit();
			System.out.println("After Commit");
			
			System.out.println("new student id"+lStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student pStudent = session.get(Student.class,lStudent.getId());
			System.out.println("get student --"+pStudent);
			session.getTransaction().commit();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
