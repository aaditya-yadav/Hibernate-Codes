package com.test.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.test.model.StudentHQL;

public class HQLDelete {

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

			count = session.createMutationQuery("DELETE FROM StudentHQL WHERE sId=:id")
					.setParameter("id", "3").executeUpdate();

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
				System.out.println("No. of rows deleted " + count);
			} else {
				transaction.rollback();
				System.out.println("No. of rows deleted " + count);
			}
		}
	}

}
