package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("John", "Smith","john.smith@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//Save the Student object to the database
			session.save(student);
			
			System.out.println("Java object saved to the database");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			
			//Get the primary key of the student
			System.out.println("Saved student. Generated Id by MySQL database : " + student.getId());
			
			//Get a new session and begin transaction
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			//Read the student
			System.out.println("Getting the student based on id: " + student.getId());
			
			Student readStudent = session.get(Student.class, student.getId());   //specify PRIMARY KEY of the student
			
			System.out.println("Retrieved student : " + student);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			
		}finally{
			
			sessionFactory.close();
		}
	}

}
