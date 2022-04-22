package com.thidinhxm.daos;

import javax.persistence.NoResultException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Course;
import com.thidinhxm.utils.HibernateUtil;

public class CourseDAO {

	public static Course getCourseByCourseName(String courseName) {
		Course course = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "from Course c where c.courseName = :courseName";
			Query<Course> query = session.createQuery(hql, Course.class);
			query.setParameter("courseName", courseName);
			course = query.getSingleResult();
			if (course != null) {
				Hibernate.initialize(course.getStudentCourse());
				Hibernate.initialize(course.getSubject());
				Hibernate.initialize(course.getPeriodIdEnd());
				Hibernate.initialize(course.getPeriodIdStart());
				Hibernate.initialize(course.getRoom());
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
		return course;
	}
}
