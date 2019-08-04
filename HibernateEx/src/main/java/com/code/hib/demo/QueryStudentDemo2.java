package com.code.hib.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Student;

public class QueryStudentDemo2 {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Create Student");
			session.beginTransaction();
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			displayStudent(studentList);
			
			studentList = session.createQuery("from Student s where s.lastName='Kant'").getResultList();
			
			System.out.println("Kant wale log");
			
			displayStudent(studentList);
			
			studentList = session.createQuery("from Student s where s.lastName='Kant' or s.firstName='JUn'").getResultList();
			
			System.out.println("Sabre log");
			
			displayStudent(studentList);
			
			studentList = session.createQuery("from Student s where s.email like 'tbdhh@%'").getResultList();
			
			System.out.println("Sabre email log");
			
			displayStudent(studentList);
			
			session.getTransaction().commit();
			System.out.println("After Commit");
			
		}
		catch(Exception e) {
			
		}
		finally {
			factory.close();
		}

	}

	public static void displayStudent(List<Student> studentList) {
		for(Student lStudent : studentList) {
			System.out.println(lStudent);
		}
	}

}
