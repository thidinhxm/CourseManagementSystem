package com.thidinhxm.daos;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import com.thidinhxm.entities.Student;
import com.thidinhxm.utils.HibernateUtil;

public class StudentDAO {
	
	public static Student getStudentByUsernameAndPassword(String username, String password) {
		Student student = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Student s where s.username = :username";
			Query<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("username", username);
			student = query.getSingleResult();
			if (student != null) {
				if (!BCrypt.checkpw(password, student.getPassword())) {
					return null;
				}
				Hibernate.initialize(student.getStudentCourse()); 
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
		return student;
	}
	
	public static List<Student> getStudents() {
		List<Student> students = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Student";
			Query<Student> query = session.createQuery(hql, Student.class);
			students = query.list();
			for (Student student : students) {
				Hibernate.initialize(student.getStudentCourse());
			}
		}
		catch (NoResultException ex) {
		}
		catch(HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return students;
	}
	
	public static Student getStudentById(String id) {
		Student student = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			student = session.get(Student.class, id);
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return student;
	}
	
	public static Boolean checkPassword(String id, String password) {
		Student student = StudentDAO.getStudentById(id);
		
		return BCrypt.checkpw(password, student.getPassword());
	}
	
	public static Boolean changeStudent(Student student) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Student st = StudentDAO.getStudentById(student.getStudentId());
		if (st == null) {
			return false;
		}
		try {
			transaction = session.beginTransaction();
			session.update(student);
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
	
	public static Boolean changePassword(String studentId, String newPassword) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Student st = StudentDAO.getStudentById(studentId);
		if (st == null) {
			return false;
		}
		
		st.setPassword(BCrypt.hashpw(newPassword, BCrypt.gensalt(10)));
		st.setLastChangePassword(LocalDateTime.now());
		try {
			transaction = session.beginTransaction();
			session.update(st);
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
