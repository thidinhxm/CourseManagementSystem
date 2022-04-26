package com.thidinhxm.ui.staff;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import com.thidinhxm.daos.CourseDAO;
import com.thidinhxm.entities.Course;

public class CoursesContainerPanel extends JPanel {


	private CardLayout cardLayout;
	private CoursesPanel coursesPane;
	private CoursePanel coursePane;
	private AddStudentPanel addStudentPane;
	private AddCoursePanel addCoursePane;
	private ResultAttendancePanel resultAttendancePane;

	public CoursesContainerPanel() {
		setBackground(new Color(255, 255, 255));
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		coursesPane = new CoursesPanel(CourseDAO.getCourses());
		coursePane = new CoursePanel();
		addStudentPane = new AddStudentPanel();
		addCoursePane = new AddCoursePanel();
		resultAttendancePane = new ResultAttendancePanel();
		
		add(coursesPane, "courses");
		add(coursePane, "course");
		add(addStudentPane, "add-student");
		add(addCoursePane, "add-course");
		add(resultAttendancePane, "result-attendance");
		
		cardLayout.show(this, "courses");
	}
	
	public void showCourse(Course course) {
		coursePane.displayCourse(course);
		coursePane.setGoToAddStudentBtn();
		cardLayout.show(this, "course");
	}
	
	public void showCourses() {
		coursesPane.unselectRow();
		cardLayout.show(this, "courses");
	}
	
	public void showAddStudent(Course course) {
		addStudentPane.setCourse(course);
		addStudentPane.setTitle();
		cardLayout.show(this, "add-student");
	}
	
	public void showAddCourse() {
		cardLayout.show(this, "add-course");
	}
	
	public void showResultAttendance(Course course) {
		resultAttendancePane.setCourse(course);
		resultAttendancePane.setTitle();
		resultAttendancePane.displayResultAttendance();
		cardLayout.show(this, "result-attendance");
	}
	
	
}
