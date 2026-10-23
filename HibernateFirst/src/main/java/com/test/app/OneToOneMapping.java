package com.test.app;

import org.hibernate.*;

import org.hibernate.cfg.Configuration;

import com.test.model.Answer;
import com.test.model.Question;

public class OneToOneMapping {
	
	public static void main(String[] args) {
		
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		config=new Configuration();
		
		config.configure();
		
		sessionFactory=config.buildSessionFactory();
		
		session = sessionFactory.openSession();
		
		Question q1 = new Question();
		q1.setId(1);
		q1.setQuestion("What is Hibernate");
		
		Answer answer = new Answer();
		answer.setId(1);
		answer.setAnswer("Hibernate is an ORM Framework");
		
		
		Question q2 = new Question();
		q2.setId(2);
		q2.setQuestion("What is JPA");
		
		Answer answer1 = new Answer();
		answer1.setId(2);
		answer1.setAnswer("It is a specification used to persist data between Java object and relational database");
		 
		q1.setAnswer(answer);
		q2.setAnswer(answer1);
		
		Question qa = session.get(Question.class, 1);
		System.out.println(qa);
		
		try {
//			transaction = session.beginTransaction();
//			session.persist(q1);
//			session.persist(q2);
//			flag=true;
			
		}
		catch(HibernateException e) {
			
			e.printStackTrace();	
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			
//			if(flag == true)
//				
//				transaction.commit();
//			else
//				transaction.rollback();
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
