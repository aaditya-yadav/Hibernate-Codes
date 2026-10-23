package com.test.app;
import org.hibernate.cfg.Configuration;

import com.test.model.Student;

import org.hibernate.*;

public class LaunchUpdate {

	public static void main(String[] args) {
		
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		config = new Configuration();
		config.configure();
		
		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Student student=new Student();
		student.setsId(3);
		student.setsName("Appa");
		student.setsCity("Mundhwa");
		
		try
		{
			transaction=session.beginTransaction();
			session.merge(student);
			flag=true;
		}
		catch(HibernateException e) 
		{
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(flag==true)
				
				transaction.commit();
			else
				
				transaction.rollback();
			
			session.close();
			sessionFactory.close();
		}
	}

}
