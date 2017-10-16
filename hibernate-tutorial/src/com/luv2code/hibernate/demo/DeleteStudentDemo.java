package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			//Deleting a single student
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Retrieving student with id : " + studentId);
			
			Student readStudent = session.get(Student.class, studentId);   //specify PRIMARY KEY of the student
			System.out.println("Deleting student...");
			
			session.delete(readStudent);
			
			/*
			//delete Student id=3001
			System.out.println("Deleting student where id=3001");
			session.createQuery("delete from Student where id=3001").executeUpdate();
			*/
			
			//commit the transaction
			session.getTransaction().commit();	
			
		}finally{
			
			sessionFactory.close();
		}
	}

}
