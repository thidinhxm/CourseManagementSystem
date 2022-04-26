package com.thidinhxm.daos;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import com.thidinhxm.entities.Staff;
import com.thidinhxm.utils.HibernateUtil;

public class StaffDAO {
	public static Staff getStaffByUsernameAndPassword(String username, String password) {
		Staff staff = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Staff s where s.username = :username ";
			Query<Staff> query = session.createQuery(hql, Staff.class);
			query.setParameter("username", username);
			staff = query.getSingleResult();
			
			if (staff != null) {
				if (!BCrypt.checkpw(password, staff.getPassword())) {
					return null;
				}
			}
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
	
	public static Staff getStaffById(String id) {
		Staff staff = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			staff = session.get(Staff.class, id);
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
	
	public static Boolean checkPassword(String id, String password) {
		Staff staff = StaffDAO.getStaffById(id);
		
		return BCrypt.checkpw(password, staff.getPassword());
	}
	
	public static Boolean changeStaff(Staff staff) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Staff st = StaffDAO.getStaffById(staff.getStaffId());
		if (st == null) {
			return false;
		}
		try {
			transaction = session.beginTransaction();
			session.update(staff);
			transaction.commit();
		} catch (HibernateException ex) {
			try {
				transaction.rollback();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
	
	public static Boolean changePassword(String staffId, String newPassword) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Staff staff = StaffDAO.getStaffById(staffId);
		if (staff == null) {
			return false;
		}
		
		staff.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(10)));
		
		try {
			transaction = session.beginTransaction();
			session.update(staff);
			transaction.commit();
		} catch (HibernateException ex) {
			try {
				transaction.rollback();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}
}
