package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		//create a Session Factory
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		
		//create a Session
		Session session = sessionFactory.getCurrentSession();
		
		try{
			
			int studentId = 3000;
			
			
			//Updating a single student
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Retrieving student with id : " + studentId);
			
			Student readStudent = session.get(Student.class, studentId);   //specify PRIMARY KEY of the student
			System.out.println("Updating student...");
			
			readStudent.setFirstName("Alex");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			//Updating all students
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Updating email for all students");
			int rowsUpdated = session.createQuery("update Student set email='hiberate@gmail.com'").executeUpdate();
			
			System.out.println("Rows updated : " + rowsUpdated);
			
			session.getTransaction().commit();
			
			
		}finally{
			
			sessionFactory.close();
		}
	}

}
