package com.thidinhxm.ui.student;

import javax.swing.JPanel;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.daos.StudentCourseDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.entities.StudentCourse;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;

public class CoursesContainerPanel extends JPanel {

	private CardLayout cardLayout;
	private CoursesPanel coursesPane;
	private CoursePanel coursePane;
	private ResultAttendancePanel resultAttendancePane;

	
	public CoursesContainerPanel(String studentId) {

		setBackground(new Color(255, 255, 255));
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		coursesPane = new CoursesPanel(StudentCourseDAO.getStudentCourseListByStudentId(studentId));
		coursePane = new CoursePanel();
		resultAttendancePane = new ResultAttendancePanel();
		
		add(coursesPane, "courses");
		add(coursePane, "course");
		add(resultAttendancePane, "result-attendance");
		
		cardLayout.show(this, "courses");
	}
	
	public void showCourse(StudentCourse studentCourse) {
		coursePane.displayStudentCourse(studentCourse);
		coursePane.setViewResultBtnAction(AttendanceDAO.getAttendanceListOfStudentCourse(studentCourse.getStudentCourseId()));
		cardLayout.show(this, "course");
	}
	
	public void showCourses() {
		coursesPane.unselectRow();
		cardLayout.show(this, "courses");
	}
	
	public void showAttendanceResult(List<Attendance> attendanceList) {
		resultAttendancePane.displayAttendanceList(attendanceList);
		cardLayout.show(this, "result-attendance");
	}
}
