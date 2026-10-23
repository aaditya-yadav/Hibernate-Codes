package com.test.app;

import java.io.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

import com.test.model.StudentInfo;

public class LaunchLOB {
	
	public static void main(String[] args) {
		
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		config=new Configuration();
		
		config.configure();
		
		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		FileInputStream fis = null;
		FileReader reader = null;
		
		byte[] image = null;
		char[] textFile = null;
		
		try {
			fis = new FileInputStream("C:\\Users\\athar\\Downloads\\Saraswati-wallart.png");
			image = new byte[fis.available()];
			fis.read(image);
			
			File file = new File("C:\\Users\\athar\\Desktop\\path.txt");
			reader = new FileReader(file);
			textFile = new char[(int)file.length()];
			reader.read(textFile);
			
		} 
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		StudentInfo studentinfo = new StudentInfo();
		
		studentinfo.setsName("Rohan");
		studentinfo.setsCity("Pune");
		studentinfo.setImage(image);
		studentinfo.setTextFile(textFile);
		
		try {
			transaction = session.beginTransaction();
			session.persist(studentinfo);	
			flag = true;
		}
		
		catch(HibernateException e) {
			e.printStackTrace();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			if(flag == true)
				
				transaction.commit();
			else
				transaction.rollback();
			
			session.close();
			sessionFactory.close();
		}
		
	}
	
}
