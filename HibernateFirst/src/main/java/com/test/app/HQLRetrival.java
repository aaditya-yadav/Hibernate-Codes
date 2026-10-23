package com.test.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.test.model.StudentHQL;

public class HQLRetrival {
	
	public static void main(String[] args) {
		
		
		
		SessionFactory sessionFactory = new Configuration().configure()
				.addAnnotatedClass(StudentHQL.class).buildSessionFactory();
		
		Session session1 = null;
		
		try {
			session1 = sessionFactory.openSession();
			
//			SELECT * FROM studenttable where scity=
//			Query<StudentHQL> query = session1.createQuery("FROM StudentHQL",StudentHQL.class);
//			query.list();
			
			Query<String> query = session1.createQuery("SELECT sName FROM StudentHQL WHERE sCity IN(:city1,:city2)",String.class);
			query.setParameter("city1", "Baner");
			query.setParameter("city2", "Magarpatta");
			List<String> list = query.list();
			
			for(String s : list) {
					System.out.println(s);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			session1.close();
			sessionFactory.close();
		}
		
	}
}
