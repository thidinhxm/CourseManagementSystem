package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
}
