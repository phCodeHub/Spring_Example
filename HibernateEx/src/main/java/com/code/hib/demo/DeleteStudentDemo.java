package com.code.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hib.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		//Create Session factory
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//Create session
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Delete Student");
			int lstudentid =3;
			System.out.println("new student id"+lstudentid);
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student pStudent = session.get(Student.class,lstudentid);
			session.delete(pStudent);
			
			System.out.println("get student --"+pStudent);
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			int row = session.createQuery("delete from Student where id = 4").executeUpdate();
			System.out.println("get row --"+row);
			
			session.getTransaction().commit();
			
			
			System.out.println("Ho gaya");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
