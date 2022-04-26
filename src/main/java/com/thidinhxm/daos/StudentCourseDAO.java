package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Student;
import com.thidinhxm.entities.StudentCourse;
import com.thidinhxm.entities.StudentCourseId;
import com.thidinhxm.utils.HibernateUtil;

public class StudentCourseDAO {
	public static List<StudentCourse> getStudentCourseListByStudentId(String studentId) {
		List<StudentCourse> studentCourseList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from StudentCourse sc where sc.student.studentId = :studentId";
			Query<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
			query.setParameter("studentId", studentId);
			studentCourseList = query.list();
			for (StudentCourse studentCourse : studentCourseList) {
				Hibernate.initialize(studentCourse.getCourse());
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
		return studentCourseList;
	}
	
	public static StudentCourse getStudentCourseByStudentCourseId(String studentId, Integer courseId) {
		StudentCourse studentCourse = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			studentCourse = (StudentCourse) session.get(StudentCourse.class, new StudentCourseId(studentId, courseId));
			if (studentCourse != null) {
				Hibernate.initialize(studentCourse.getCourse());
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
		return studentCourse;
	}
	
	public static List<StudentCourse> getStudentCourseListByCourseId(String courseId) {
		List<StudentCourse> studentCourseList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from StudentCourse sc where sc.studentCourseId.courseId = :courseId";
			Query<StudentCourse> query = session.createQuery(hql, StudentCourse.class);
			query.setParameter("courseId", courseId);
			studentCourseList = query.list();
			for (StudentCourse sc : studentCourseList) {
				Hibernate.initialize(sc.getAttendances());
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
		return studentCourseList;
	}
	
	public static Boolean addStudentToCourse(StudentCourse studentCourse) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(studentCourse);
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
