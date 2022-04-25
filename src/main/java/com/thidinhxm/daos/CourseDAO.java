package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Course;
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
	
	public static Course getCourse(int courseId) {
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
}
