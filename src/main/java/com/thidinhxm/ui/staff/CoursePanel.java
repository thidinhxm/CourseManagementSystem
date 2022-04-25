package com.thidinhxm.ui.staff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.StudentCourse;
import com.thidinhxm.utils.DateTimeUtil;

public class CoursePanel extends JPanel {

	private JLabel lblTitle;
	private JLabel lblDateStart;
	private JLabel lblDateEnd;
	private JLabel lblDateLearn;
	private JLabel lblTimeStart;
	private JLabel lblTimeEnd;
	private JLabel lblRoom;
	private JButton btnAddStudent;
	private JButton btnBack;
	private JLabel lblSubjectName;
	private JLabel lblSubjectId;
	private JButton btnResultAttendance;


	public CoursePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		lblTitle = new JLabel("Thông tin khóa học: ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(158, 10, 610, 49);
		add(lblTitle);
		
		lblDateStart = new JLabel("Ngày bắt đầu: ");
		lblDateStart.setForeground(new Color(112, 128, 144));
		lblDateStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateStart.setBounds(89, 153, 301, 22);
		add(lblDateStart);
		
		lblDateEnd = new JLabel("Ngày kết thúc");
		lblDateEnd.setForeground(new Color(112, 128, 144));
		lblDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateEnd.setBounds(440, 153, 464, 22);
		add(lblDateEnd);
		
		lblDateLearn = new JLabel("Ngày học: ");
		lblDateLearn.setForeground(new Color(112, 128, 144));
		lblDateLearn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateLearn.setBounds(89, 260, 301, 22);
		add(lblDateLearn);
		
		lblTimeStart = new JLabel("Từ: ");
		lblTimeStart.setForeground(new Color(112, 128, 144));
		lblTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeStart.setBounds(89, 209, 301, 22);
		add(lblTimeStart);
		
		lblTimeEnd = new JLabel("Đến: ");
		lblTimeEnd.setForeground(new Color(112, 128, 144));
		lblTimeEnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeEnd.setBounds(440, 209, 464, 22);
		add(lblTimeEnd);
		
		lblRoom = new JLabel("Phòng học: ");
		lblRoom.setForeground(new Color(112, 128, 144));
		lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoom.setBounds(440, 260, 464, 22);
		add(lblRoom);
		
		btnAddStudent = new JButton("Thêm sinh viên");
		btnAddStudent.setForeground(new Color(255, 255, 255));
		btnAddStudent.setBackground(new Color(25, 25, 112));
		btnAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddStudent.setBounds(351, 386, 214, 36);
		
		add(btnAddStudent);
		
		btnBack = new JButton("Quay lại");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToCourses();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(614, 386, 214, 36);
		add(btnBack);
		
		lblSubjectName = new JLabel("Tên môn học: ");
		lblSubjectName.setForeground(new Color(112, 128, 144));
		lblSubjectName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubjectName.setBounds(440, 103, 464, 22);
		add(lblSubjectName);
		
		lblSubjectId = new JLabel("Mã môn học: ");
		lblSubjectId.setForeground(new Color(112, 128, 144));
		lblSubjectId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubjectId.setBounds(89, 103, 301, 22);
		add(lblSubjectId);
		
		btnResultAttendance = new JButton("Kết quả điểm danh");
		btnResultAttendance.setForeground(Color.WHITE);
		btnResultAttendance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnResultAttendance.setBackground(new Color(25, 25, 112));
		btnResultAttendance.setBounds(89, 386, 214, 36);
		add(btnResultAttendance);
	}
	
	public void displayCourse(Course course) {
		lblTitle.setText("Khóa học: " + course.getCourseName());
		lblSubjectId.setText("Mã môn học: " + course.getSubject().getSubjectId());
		lblSubjectName.setText("Tên môn học: " + course.getSubject().getSubjectName());
		lblDateStart.setText("Ngày bắt đầu: " + DateTimeUtil.getLocalDateString(course.getDateStart()));
		lblDateEnd.setText("Ngày kết thúc: " + DateTimeUtil.getLocalDateString(course.getDateEnd()));
		lblDateLearn.setText("Ngày học: " + course.getDayInWeek());
		lblTimeStart.setText("Từ: " + course.getPeriodIdStart().getTimeStart());
		lblTimeEnd.setText("Đến: " + course.getPeriodIdEnd().getTimeEnd());
		lblRoom.setText("Phòng học: " + course.getRoom().getRoomName());
		
	}
	
	private void backToCourses() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showCourses();
	}
	
	private void goToStudentsInCourse(List<StudentCourse> studentCourseList) {
		
	}
	
	public void setViewStudentsInCourse(final List<StudentCourse> studentCourseList) {
		btnResultAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToStudentsInCourse(studentCourseList);
			}
		});
	}
	
	public void goToAddStudent() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showAddStudent();
	}
	
	public void setGoToAddStudentBtn() {
		btnAddStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToAddStudent();
			}
		});
	}

}
