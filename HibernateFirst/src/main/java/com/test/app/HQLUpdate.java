package com.test.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.test.model.StudentHQL;

public class HQLUpdate {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(StudentHQL.class)
				.buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		int count = 0;

		try {

			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			count = session.createMutationQuery("UPDATE StudentHQL SET sCity = :city WHERE sName=:name").
					setParameter("city", "Baner").setParameter("name", "Aadi").executeUpdate();

			flag = true;

		}

		catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("No. of rows updated " + count);
			} else {
				transaction.rollback();
				System.out.println("No. of rows updated " + count);
			}
		}
	}

}
