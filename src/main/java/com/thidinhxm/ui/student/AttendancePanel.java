package com.thidinhxm.ui.student;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.daos.CourseDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.Student;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttendancePanel extends JPanel {
	private JTextField txtTime;
	
	private Student student;
	private Attendance attendance;
	private Course course;
	
	private JPanel attendPane;

	private JLabel lblDateLearn;

	private JLabel lblTimeEnd;

	private JLabel lblTimeStart;

	private JLabel lblCourseName;

	private JButton btnAttendance;

	private JPanel notAttendPane;
	public AttendancePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Điểm danh khóa học");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(341, 0, 236, 39);
		add(lblTitle);
		
		notAttendPane = new JPanel();
		notAttendPane.setBackground(new Color(255, 255, 255));
		notAttendPane.setLayout(null);
		notAttendPane.setBounds(75, 71, 810, 410);
		notAttendPane.setVisible(false);
		add(notAttendPane);
		
		btnAttendance = new JButton("Điểm danh");
		btnAttendance.setForeground(Color.WHITE);
		btnAttendance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAttendance.setBackground(new Color(25, 25, 112));
		btnAttendance.setBounds(312, 343, 125, 39);
		btnAttendance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				handleButtonClick();
				
			}
			
		});
		notAttendPane.add(btnAttendance);
		
		lblDateLearn = new JLabel("Ngày học: ");
		lblDateLearn.setBounds(179, 199, 400, 47);
		notAttendPane.add(lblDateLearn);
		lblDateLearn.setForeground(new Color(112, 128, 144));
		lblDateLearn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblTimeEnd = new JLabel("Đến ");
		lblTimeEnd.setBounds(179, 132, 400, 47);
		notAttendPane.add(lblTimeEnd);
		lblTimeEnd.setForeground(new Color(112, 128, 144));
		lblTimeEnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblTimeStart = new JLabel("Từ: ");
		lblTimeStart.setBounds(179, 75, 400, 47);
		notAttendPane.add(lblTimeStart);
		lblTimeStart.setForeground(new Color(112, 128, 144));
		lblTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblCourseName = new JLabel("Tên khóa học: ");
		lblCourseName.setBounds(179, 10, 621, 47);
		notAttendPane.add(lblCourseName);
		lblCourseName.setForeground(new Color(112, 128, 144));
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		attendPane = new JPanel();
		attendPane.setBackground(new Color(255, 255, 255));
		attendPane.setBounds(75, 71, 810, 410);
		add(attendPane);
		attendPane.setLayout(null);
		
		JLabel lblNotification = new JLabel("Hiện tại không có khóa học nào để điểm danh");
		lblNotification.setBounds(74, 176, 620, 39);
		lblNotification.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotification.setForeground(new Color(25, 25, 112));
		lblNotification.setFont(new Font("Tahoma", Font.BOLD, 18));
		attendPane.add(lblNotification);
		
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void updateLayout() {
		Course currentCourse = CourseDAO.getCurrentCourseOfStudent(student.getStudentId());
		if (currentCourse != null) {
			Attendance currentAttendance = AttendanceDAO.getCurrentAttendance(student.getStudentId(), currentCourse.getCourseId());
			if (currentAttendance != null) {
				attendance = currentAttendance;
				course = currentCourse;
				
				lblCourseName.setText("Tên khóa học: " + currentCourse.getCourseName());
				lblDateLearn.setText("Ngày học: " + currentCourse.getDayInWeek());
				lblTimeStart.setText("Từ: " + currentCourse.getPeriodIdStart().getTimeStart());
				lblTimeEnd.setText("Đến: " + currentCourse.getPeriodIdEnd().getTimeEnd());
				
				attendPane.setVisible(false);
				notAttendPane.setVisible(true);
				
			}
			else {
				attendPane.setVisible(true);
				notAttendPane.setVisible(false);
			}
		}
		else {
			attendPane.setVisible(true);
			notAttendPane.setVisible(false);
		}
	}
	
	public void handleButtonClick() {
		AttendanceDAO.changePresent(student.getStudentId(), course.getCourseId(), attendance.getAttendanceId().getWeekLearn(), true);
		JOptionPane.showMessageDialog(this, "Điểm danh thành công");
		updateLayout();
	}
}
