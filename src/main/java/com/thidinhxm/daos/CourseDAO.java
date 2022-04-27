package com.thidinhxm.daos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Course;
import com.thidinhxm.utils.DateTimeUtil;
import com.thidinhxm.utils.HibernateUtil;

public class CourseDAO {

	public static List<Course> getCourses() {
		List<Course> courses = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Course";
			Query<Course> query = session.createQuery(hql, Course.class);
			courses = query.list();
			
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return courses;
	}
	
	public static Course getCourseById(int courseId) {
		Course course = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			course = session.get(Course.class, courseId);
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return course;
	}
	
	public static Boolean addCourse(Course course) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(course);
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
	
	public static Course getCurrentCourseOfStudent(String studentId) {
		List<Course> courses = null;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		LocalDate nowDate = LocalDate.now();
		
		try {
			String hql = "select c from Course c join StudentCourse sc on c.courseId = sc.studentCourseId.courseId"
					+ " where sc.studentCourseId.studentId = :studentId "
					+ "and c.periodIdStart.timeStart <= current_time() and c.periodIdEnd.timeEnd >= current_time()";
			Query<Course> query = session.createQuery(hql, Course.class);
			query.setParameter("studentId", studentId);
			courses = query.list();
			for (Course course : courses) {
				if (DateTimeUtil.getVietnameseDayOfWeek(nowDate.getDayOfWeek()).equals(course.getDayInWeek())) {
					return course;
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
		return null;
	}
}
