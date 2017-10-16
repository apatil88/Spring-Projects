package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		//create a Session Factory
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		
		//create a Session
		Session session = sessionFactory.getCurrentSession();
		
		try{
			
			System.out.println("Creating a new Student object...");
			
			//create the Student object
			Student student = new Student("Paul", "Walker","paul.walker@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//Save the Student object to the database
			session.save(student);
			
			System.out.println("Java object saved to the database");
			//commit the transaction
			session.getTransaction().commit();
			
		}finally{
			
			sessionFactory.close();
		}
	}

}
