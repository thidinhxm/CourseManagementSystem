package com.thidinhxm.daos;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Staff;
import com.thidinhxm.utils.HibernateUtil;

public class StaffDAO {
	public static Staff getStaffByUsernameAndPassword(String username, String password) {
		Staff staff = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Staff s where s.username = " + username + " and s.password = " + password;
			Query<Staff> query = session.createQuery(hql, Staff.class);
			staff = query.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return staff;
	}
}
