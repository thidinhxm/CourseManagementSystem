package com.thidinhxm.ui.student;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.thidinhxm.entities.Attendance;
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
	private JButton btnViewResult;
	private JButton btnBack;
	private JLabel lblSubjectName;
	private JLabel lblSubjectId;
	private JLabel lblPoint;
	private JLabel lblClassification;

	/**
	 * Create the panel.
	 */
	public CoursePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		lblTitle = new JLabel("Khoá học: ");
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
		
		btnViewResult = new JButton("Xem kết quả điểm danh");
		btnViewResult.setForeground(new Color(255, 255, 255));
		btnViewResult.setBackground(new Color(25, 25, 112));
		btnViewResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewResult.setBounds(89, 386, 255, 36);
		add(btnViewResult);
		
		btnBack = new JButton("Quay lại");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToCourses();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(440, 386, 255, 36);
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
		
		lblPoint = new JLabel("Điểm khóa học: ");
		lblPoint.setForeground(new Color(112, 128, 144));
		lblPoint.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPoint.setBounds(89, 318, 301, 22);
		add(lblPoint);
		
		lblClassification = new JLabel("Xếp loại: ");
		lblClassification.setForeground(new Color(112, 128, 144));
		lblClassification.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClassification.setBounds(440, 318, 464, 22);
		add(lblClassification);
	}
	
	public void displayStudentCourse(StudentCourse studentCourse) {
		Course course = studentCourse.getCourse();
		lblTitle.setText("Khóa học: " + course.getCourseName());
		lblSubjectId.setText("Mã môn học: " + course.getSubject().getSubjectId());
		lblSubjectName.setText("Tên môn học: " + course.getSubject().getSubjectName());
		lblDateStart.setText("Ngày bắt đầu: " + DateTimeUtil.getLocalDateString(course.getDateStart()));
		lblDateEnd.setText("Ngày kết thúc: " + DateTimeUtil.getLocalDateString(course.getDateEnd()));
		lblDateLearn.setText("Ngày học: " + course.getDayInWeek());
		lblTimeStart.setText("Từ: " + course.getPeriodIdStart().getTimeStart());
		lblTimeEnd.setText("Đến: " + course.getPeriodIdEnd().getTimeEnd());
		lblRoom.setText("Phòng học: " + course.getRoom().getRoomName());
		
		String pointString = "";
		String classification = "";
		if (studentCourse.getPoint() == null) {
			pointString = "Chưa có";
			classification = "Chưa có";
		}
		else {
			pointString = studentCourse.getPoint() + "";
			if (studentCourse.getPoint() < 5) {
				classification = "Rớt";
			}
			else {
				classification = "Đậu";
			}
		}
		
		lblPoint.setText("Điểm: " + pointString);
		lblClassification.setText("Loại: " + classification);
		
	}
	
	private void backToCourses() {
		StudentScreen screen = (StudentScreen) SwingUtilities.windowForComponent(this);
		screen.showCourses();
	}
	
	private void goToAttendanceResult(List<Attendance> atendanceList) {
		StudentScreen screen = (StudentScreen) SwingUtilities.windowForComponent(this);
		screen.showAttendanceResult(atendanceList);
	}
	
	public void setViewResultBtnAction(final List<Attendance> atendanceList) {
		
		btnViewResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToAttendanceResult(atendanceList);
			}
		}) ;
	}
}
