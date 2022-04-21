package com.thidinhxm.ui.staff;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.thidinhxm.ui.partials.AccountPanel;
import com.thidinhxm.ui.partials.HeaderPanel;

import java.awt.Color;

public class StaffScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffScreen frame = new StaffScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StaffScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HeaderPanel headerPane = new HeaderPanel("Xuân Thi");
		headerPane.setLocation(20, 10);
		contentPane.add(headerPane);
		
		JPanel sidebarPane = new JPanel();
		sidebarPane.setBackground(new Color(248, 248, 255));
		sidebarPane.setBounds(0, 70, 194, 490);
		contentPane.add(sidebarPane);
		sidebarPane.setLayout(null);
		
		JLabel lblCourse = new JLabel("Môn học");
		lblCourse.setVerticalAlignment(SwingConstants.CENTER);
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setForeground(new Color(25, 25, 112));
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCourse.setBounds(0, 28, 193, 41);
		sidebarPane.add(lblCourse);
		
		JLabel lblAttendance = new JLabel("Khóa học");
		lblAttendance.setVerticalAlignment(SwingConstants.CENTER);
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setForeground(new Color(25, 25, 112));
		lblAttendance.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAttendance.setBounds(0, 79, 193, 41);
		sidebarPane.add(lblAttendance);
		
		JLabel lblLogOut = new JLabel("Đăng xuất");
		lblLogOut.setVerticalAlignment(SwingConstants.CENTER);
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(new Color(25, 25, 112));
		lblLogOut.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLogOut.setBounds(0, 449, 193, 41);
		sidebarPane.add(lblLogOut);
		
		JLabel lblResultAttendace = new JLabel("Sinh viên");
		lblResultAttendace.setVerticalAlignment(SwingConstants.CENTER);
		lblResultAttendace.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultAttendace.setForeground(new Color(25, 25, 112));
		lblResultAttendace.setFont(new Font("Dialog", Font.BOLD, 16));
		lblResultAttendace.setBounds(0, 130, 193, 41);
		sidebarPane.add(lblResultAttendace);
		
		JLabel lblAccount = new JLabel("Tài khoản");
		lblAccount.setVerticalAlignment(SwingConstants.CENTER);
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setForeground(new Color(25, 25, 112));
		lblAccount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAccount.setBounds(0, 181, 193, 41);
		sidebarPane.add(lblAccount);
		
		JLabel lblInformation = new JLabel("Hệ thống được phát triển bởi tác giả Đinh Trần Xuân Thi");
		lblInformation.setForeground(new Color(25, 25, 112));
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformation.setBounds(405, 579, 382, 24);
		contentPane.add(lblInformation);
		
		JPanel mainPane = new JPanel();
		mainPane.setBackground(new Color(255, 255, 255));
		mainPane.setBounds(194, 70, 970, 490);
		contentPane.add(mainPane);
		mainPane.setLayout(new CardLayout(0, 0));
		
//		AccountPanel coursePane = new AccountPanel();
//		CoursePanel coursePane2 = new CoursePanel();
		AddStudentPanel pn = new AddStudentPanel();
//		mainPane.add(coursePane);
		mainPane.add(pn);
	}

}
