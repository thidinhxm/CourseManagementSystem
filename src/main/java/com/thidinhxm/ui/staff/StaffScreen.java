package com.thidinhxm.ui.staff;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.thidinhxm.daos.CourseDAO;
import com.thidinhxm.entities.Staff;
import com.thidinhxm.ui.partials.HeaderPanel;

import java.awt.Color;

public class StaffScreen extends JFrame {

	private JPanel contentPane;
	private JPanel txtAccountPane;
	private JLabel lblAccount;
	private JLabel lblSubject;
	private JPanel txtStudentPane;
	private JLabel lblStudent;
	private JPanel txtCoursePane;
	private JLabel lblCourse;
	private JPanel txtLogOutPane;
	private JLabel lblLogOut;
	private JPanel txtSubjectPane;
	
	private static final Color FIRST_COLOR = new Color(248, 248, 255);
	private static final Color SECOND_COLOR = new Color(25, 25, 112);
	private static final Color THIRD_COLOR = new Color(0, 0, 205);
	
	public StaffScreen(Staff staff) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HeaderPanel headerPane = new HeaderPanel(staff.getFullname());
		headerPane.setLocation(20, 10);
		contentPane.add(headerPane);
		
		JPanel sidebarPane = new JPanel();
		sidebarPane.setBackground(new Color(248, 248, 255));
		sidebarPane.setBounds(11, 70, 182, 490);
		contentPane.add(sidebarPane);
		sidebarPane.setLayout(null);
		
		txtAccountPane = new JPanel();
		txtAccountPane.setLayout(null);
		txtAccountPane.setBackground(new Color(248, 248, 255));
		txtAccountPane.setBounds(0, 153, 182, 41);
		sidebarPane.add(txtAccountPane);
		
		lblAccount = new JLabel("Tài khoản");
		lblAccount.setVerticalAlignment(SwingConstants.CENTER);
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setForeground(new Color(25, 25, 112));
		lblAccount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAccount.setBounds(0, 0, 182, 41);
		lblAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPane();
				txtAccountPane.setBackground(THIRD_COLOR);
				lblAccount.setForeground(Color.WHITE);
			}
		});
		txtAccountPane.add(lblAccount);
		
		txtSubjectPane = new JPanel();
		txtSubjectPane.setLayout(null);
		txtSubjectPane.setBackground(new Color(248, 248, 255));
		txtSubjectPane.setBounds(0, 51, 182, 41);
		sidebarPane.add(txtSubjectPane);
		
		lblSubject = new JLabel("Môn học");
		lblSubject.setVerticalAlignment(SwingConstants.CENTER);
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setForeground(new Color(25, 25, 112));
		lblSubject.setFont(new Font("Dialog", Font.BOLD, 16));
		lblSubject.setBounds(0, 0, 182, 41);
		lblSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPane();
				txtSubjectPane.setBackground(THIRD_COLOR);
				lblSubject.setForeground(Color.WHITE);
			}
		});
		txtSubjectPane.add(lblSubject);
		
		txtStudentPane = new JPanel();
		txtStudentPane.setLayout(null);
		txtStudentPane.setBackground(new Color(248, 248, 255));
		txtStudentPane.setBounds(0, 102, 182, 41);
		sidebarPane.add(txtStudentPane);
		
		lblStudent = new JLabel("Sinh Viên");
		lblStudent.setVerticalAlignment(SwingConstants.CENTER);
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setForeground(new Color(25, 25, 112));
		lblStudent.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStudent.setBounds(0, 0, 182, 41);
		lblStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPane();
				txtStudentPane.setBackground(THIRD_COLOR);
				lblStudent.setForeground(Color.WHITE);
			}
		});
		txtStudentPane.add(lblStudent);
		
		txtCoursePane = new JPanel();
		txtCoursePane.setLayout(null);
		txtCoursePane.setBackground(THIRD_COLOR);
		txtCoursePane.setBounds(0, 0, 182, 41);
		sidebarPane.add(txtCoursePane);
		
		lblCourse = new JLabel("Khóa học");
		lblCourse.setVerticalAlignment(SwingConstants.CENTER);
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setForeground(new Color(255, 255, 255));
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCourse.setBounds(0, 0, 182, 41);
		lblCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPane();
				txtCoursePane.setBackground(THIRD_COLOR);
				lblCourse.setForeground(Color.WHITE);
			}
		});
		txtCoursePane.add(lblCourse);
		
		txtLogOutPane = new JPanel();
		txtLogOutPane.setLayout(null);
		txtLogOutPane.setBackground(new Color(248, 248, 255));
		txtLogOutPane.setBounds(0, 449, 182, 41);
		sidebarPane.add(txtLogOutPane);
		
		lblLogOut = new JLabel("Đăng xuất");
		lblLogOut.setVerticalAlignment(SwingConstants.CENTER);
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(new Color(25, 25, 112));
		lblLogOut.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLogOut.setBackground(new Color(248, 248, 255));
		lblLogOut.setBounds(0, 0, 182, 41);
		txtLogOutPane.add(lblLogOut);
		
		JLabel lblInformation = new JLabel("Hệ thống được phát triển bởi tác giả Đinh Trần Xuân Thi");
		lblInformation.setForeground(new Color(25, 25, 112));
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformation.setBounds(405, 579, 382, 24);
		contentPane.add(lblInformation);
		
		JPanel mainPane = new JPanel();
		mainPane.setBackground(new Color(255, 255, 255));
		mainPane.setBounds(204, 70, 960, 490);
		contentPane.add(mainPane);
		mainPane.setLayout(new CardLayout(0, 0));
		

		CoursesPanel pn = new CoursesPanel(CourseDAO.getCourses());

		mainPane.add(pn);
		
		setVisible(true);
	}
	
	private void resetPane() {
		txtCoursePane.setBackground(FIRST_COLOR);
		txtSubjectPane.setBackground(FIRST_COLOR);
		txtStudentPane.setBackground(FIRST_COLOR);
		txtAccountPane.setBackground(FIRST_COLOR);
		
		lblCourse.setForeground(SECOND_COLOR);
		lblSubject.setForeground(SECOND_COLOR);
		lblStudent.setForeground(SECOND_COLOR);
		lblAccount.setForeground(SECOND_COLOR);
	}
}
