package com.test.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.model.Student;

public class LaunchFirstApp {

	public static void main(String[] args) {
		
		//Step 01 Configuration Object
		Configuration config = new Configuration();
		
		//Step 02 Configure hibernate.cfg.xml file to COnfiguration Object
		config.configure();
		
		//Step 03 Create SessionFactory Object
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//Step 04 Get the Session Object from Session Factory
		Session session = sessionFactory.openSession();
		
		//Step 05 Begin the Transaction within Session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setsId(3);
		student.setsName("Appa");
		student.setsCity("Padal");
		
		//Step 06 Perform Operation
		session.persist(student);
		
		//Step 07 Performing Transaction Operations
		transaction.commit();
		
		//Step 08 Close the Session
		session.close();
		
	}
}

