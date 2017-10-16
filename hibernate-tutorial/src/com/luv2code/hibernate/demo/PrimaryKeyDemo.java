package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create a Session Factory
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		
		//create a Session
		Session session = sessionFactory.getCurrentSession();
		
		try{
			
			System.out.println("Creating 3 student objects...");
			
			//create 3 Student objects
			Student student1 = new Student("John", "Walker","john.walker@gmail.com");
			Student student2 = new Student("Mary", "Walker","mary.walker@gmail.com");
			Student student3 = new Student("Richard", "Walker","richard.walker@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//Save the 3 Student objects to the database
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			System.out.println("Java objects saved to the database");
			
			//commit the transaction
			session.getTransaction().commit();
			
		}finally{
			
			sessionFactory.close();
		}
	}

}
