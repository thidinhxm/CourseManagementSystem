package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.thidinhxm.entities.Attendance;
import com.thidinhxm.entities.StudentCourseId;
import com.thidinhxm.utils.HibernateUtil;

public class AttendanceDAO {
	public static List<Attendance> getAttendanceListOfStudentCourse(StudentCourseId studentCourseId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Attendance> attendanceList = null;
		try {
			String hql = "from Attendance a where a.attendanceId.studentCourseId = :studentCourseId";
			Query<Attendance> query = session.createQuery(hql, Attendance.class);
			query.setParameter("studentCourseId", studentCourseId);
			attendanceList = query.list();
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return attendanceList;
		
	}
	
	public static Attendance getCurrentAttenddance(String studentId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Attendance attendance = null;
		try {
			String hql = "select a from Attendance a inner join Course c on a.attendanceId.studentCourseId.courseId = c.courseId"
					+ " where a.attendanceId.studentCourseId.studentId = :studentId"
					+ "and Date(a.attendanceId.dateLearn) = Date(current_date())"
					+ "and c.";
			Query<Attendance> query = session.createQuery(hql, Attendance.class);
			query.setParameter("studentId", studentId);
			attendance = query.getSingleResult();
		}
		catch (NoResultException ex) {
		}
		catch (HibernateException ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return attendance;
	}
	
	public static Boolean addAttendance(Attendance attendance) { 
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(attendance);
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
