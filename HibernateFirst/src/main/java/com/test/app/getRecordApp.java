package com.test.app;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.model.Student;

public class getRecordApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = null;	
		Session session1 = null;
		
		try 
		{
			session = sessionFactory.openSession();
			session1 = sessionFactory.openSession();
			
			Student student = session.get(Student.class, 1);
			System.out.println(student);
	
			Student student1 = session.get(Student.class, 2);
			System.out.println(student1);
			
			Student student2 = session1.get(Student.class, 1);
			System.out.println(student2);
	
			Student student3 = session1 .get(Student.class, 1);
			System.out.println(student3);
			
			//Student student = session.load(Student.class, 1);
			//Student student = session.getReference(Student.class, 1);
			//System.out.println("Id is :"+ student.getsId());
			//System.out.println("Name is :"+ student.getsName());
			//System.out.println("City is :"+ student.getsCity());
			
		}
		
		catch(HibernateException e){
			e.printStackTrace();
		}
		
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		finally {
			session.close();
			sessionFactory.close();
			
		}
	}

}
