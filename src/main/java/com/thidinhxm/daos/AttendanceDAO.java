package com.thidinhxm.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
}
