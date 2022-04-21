package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Student;
import com.thidinhxm.utils.HibernateUtil;

public class StudentDAO {
	
	public static Student getStudentByUsernameAndPassword(String username, String password) {
		Student student = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Student s where s.username = :username and s.password = : password";
			Query<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			student = query.getSingleResult();
			if (student != null) {
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
	
	public static Student getStudentInformation(String studentId) {
		Student student = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			student = (Student) session.get(Student.class, studentId);
			if (student != null) {
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
	
}
