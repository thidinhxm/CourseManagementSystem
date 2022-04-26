package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thidinhxm.entities.Subject;
import com.thidinhxm.utils.HibernateUtil;

public class SubjectDAO {
	public static Subject getSubjectById(String subjectId) {
		Subject subject = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			subject = session.get(Subject.class, subjectId);
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return subject;
	}
	
	public static List<Subject> getSubjects() {
		List<Subject> subjects = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Subject s";
			Query<Subject> query = session.createQuery(hql, Subject.class);
			subjects = query.list();
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return subjects;
	}
	
	public static Boolean addSubject(Subject subject) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		if (SubjectDAO.getSubjectById(subject.getSubjectId()) != null) {
			return false;
		}
		try {
			transaction = session.beginTransaction();
			session.save(subject);
			transaction.commit();
		}
		catch (HibernateException ex) {
			try {
				transaction.rollback();
				return false;
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
