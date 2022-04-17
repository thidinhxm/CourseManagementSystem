package com.thidinhxm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.thidinhxm.entities.Staff;
import com.thidinhxm.utils.HibernateUtil;

public class App {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	}
}
