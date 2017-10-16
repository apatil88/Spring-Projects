package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		//create a Session Factory
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).
				buildSessionFactory();
		
		
		//create a Session
		Session session = sessionFactory.getCurrentSession();
		
		try{
			
			
			//start a transaction
			session.beginTransaction();
			
			//query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			/*for(Student student : theStudents){
				System.out.println(student);
			}*/
			
			//query students whose lastName : 'Smith'
			theStudents = session.createQuery(" from Student s where s.lastName='Smith' ").getResultList();
			System.out.println("\n\nDisplay students with lastName: Smith ");
			for(Student student : theStudents){
				System.out.println(student);
			}
			
			
			//query students with lastName : 'Smith' OR firstName : 'Mary'
			theStudents = session.createQuery(" from Student s where s.lastName='Smith' OR s.firstName='Mary' ").getResultList();
			System.out.println("\n\nDisplay students with lastName : 'Smith' OR firstName : 'Mary' ");
			for(Student student : theStudents){
				System.out.println(student);
			}
			
			//query students with email ending with "gmail.com"
			theStudents = session.createQuery(" from Student s where s.email LIKE '%gmail.com' ").getResultList();
			System.out.println("\n\nDisplay students with email ending with 'gmail.com' ");
			for(Student student : theStudents){
				System.out.println(student);
			}
			
			//commit the transaction
			session.getTransaction().commit();
			
		}finally{
			
			sessionFactory.close();
		}
	}

}
