package com.test.app;

import java.io.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.test.model.StudentInfo;

public class LOBRetrival {

	public static void main(String[] args) {

		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		FileOutputStream fos = null;
		FileWriter writer = null;

		byte[] image = null;
		char[] textFile = null;

		config = new Configuration();

		config.configure();

		sessionFactory = config.buildSessionFactory();

		session = sessionFactory.openSession();
		StudentInfo studentInfo = session.get(StudentInfo.class, 1);

		try {
			fos = new FileOutputStream("saraswati.png");
			writer = new FileWriter("path.txt");
			fos.write(studentInfo.getImage());
			writer.write(studentInfo.getTextFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		
		 finally {

			session.close();
			sessionFactory.close();

			try {
				writer.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
