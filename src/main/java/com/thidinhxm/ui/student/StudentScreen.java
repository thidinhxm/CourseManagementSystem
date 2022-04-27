package com.thidinhxm.ui.student;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.daos.StudentCourseDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.entities.Student;
import com.thidinhxm.entities.StudentCourse;
import com.thidinhxm.ui.partials.AccountPanel;
import com.thidinhxm.ui.partials.ChangePasswordPanel;
import com.thidinhxm.ui.partials.HeaderPanel;
import com.thidinhxm.ui.partials.LoginScreen;

import java.awt.CardLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class StudentScreen extends JFrame {

	private JPanel contentPane;
	private JPanel txtCoursePane;
	private JLabel lblCourse;
	private JPanel txtAccountPane;
	private JLabel lblAccount;
	private JPanel txtAttendancePane;
	private JLabel lblAttendance;
	private JPanel txtLogOutPane;
	private CardLayout cardLayout;
	private AccountPanel accountPane;
	private JPanel mainPane;
	private Student student;
	private AttendancePanel attendancePane;
	private CoursesContainerPanel coursesContainerPane;
	private ChangePasswordPanel changePasswordPane;
	private static final Color FIRST_COLOR = new Color(248, 248, 255);
	private static final Color SECOND_COLOR = new Color(25, 25, 112);
	private static final Color THIRD_COLOR = new Color(0, 0, 205);

	public StudentScreen(Student student) {
		
		this.student = student;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		HeaderPanel headerPane = new HeaderPanel(student.getFullname());
		headerPane.setLocation(20, 10);
		contentPane.add(headerPane);
		
		JPanel sidebarPane = new JPanel();
		sidebarPane.setBackground(new Color(248, 248, 255));
		sidebarPane.setBounds(11, 70, 182, 490);
		contentPane.add(sidebarPane);
		sidebarPane.setLayout(null);
		
		txtCoursePane = new JPanel();
		txtCoursePane.setBackground(new Color(0, 0, 205));
		txtCoursePane.setBounds(0, 0, 182, 41);
		sidebarPane.add(txtCoursePane);
		txtCoursePane.setLayout(null);
		
		lblCourse = new JLabel("Khóa học");
		lblCourse.setBounds(0, 0, 182, 41);
		txtCoursePane.add(lblCourse);
		lblCourse.setVerticalAlignment(SwingConstants.CENTER);
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setForeground(new Color(255, 255, 255));
		lblCourse.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPanes();
				txtCoursePane.setBackground(THIRD_COLOR);
				lblCourse.setForeground(Color.WHITE);
				showCourses();
				cardLayout.show(mainPane, "courses-container");
			}
		});
		
		txtAccountPane = new JPanel();
		txtAccountPane.setBackground(new Color(248, 248, 255));
		txtAccountPane.setBounds(0, 102, 182, 41);
		sidebarPane.add(txtAccountPane);
		txtAccountPane.setLayout(null);
		

		lblAccount = new JLabel("Tài khoản");
		lblAccount.setBackground(new Color(255, 255, 255));
		lblAccount.setBounds(0, 0, 182, 41);
		txtAccountPane.add(lblAccount);
		lblAccount.setVerticalAlignment(SwingConstants.CENTER);
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setForeground(new Color(25, 25, 112));
		lblAccount.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPanes();
				txtAccountPane.setBackground(THIRD_COLOR);
				lblAccount.setForeground(Color.WHITE);
				cardLayout.show(mainPane, "account");			
			}
		});
		
		txtAttendancePane = new JPanel();
		txtAttendancePane.setBackground(new Color(248, 248, 255));
		txtAttendancePane.setBounds(0, 51, 182, 41);
		sidebarPane.add(txtAttendancePane);
		txtAttendancePane.setLayout(null);
		
		lblAttendance = new JLabel("Điểm danh");
		lblAttendance.setBackground(new Color(255, 255, 255));
		lblAttendance.setBounds(0, 0, 182, 41);
		txtAttendancePane.add(lblAttendance);
		lblAttendance.setVerticalAlignment(SwingConstants.CENTER);
		lblAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendance.setForeground(new Color(25, 25, 112));
		lblAttendance.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPanes();
				txtAttendancePane.setBackground(THIRD_COLOR);
				lblAttendance.setForeground(Color.WHITE);
				cardLayout.show(mainPane, "attendance");
				attendancePane.updateLayout();
			}
		});
		
		txtLogOutPane = new JPanel();
		txtLogOutPane.setBackground(new Color(248, 248, 255));
		txtLogOutPane.setLayout(null);
		txtLogOutPane.setBounds(0, 449, 182, 41);
		sidebarPane.add(txtLogOutPane);
		
		JLabel lblLogOut = new JLabel("Đăng xuất");
		lblLogOut.setBackground(new Color(248, 248, 255));
		lblLogOut.setBounds(0, 0, 182, 41);
		txtLogOutPane.add(lblLogOut);
		lblLogOut.setVerticalAlignment(SwingConstants.CENTER);
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(new Color(25, 25, 112));
		lblLogOut.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(mainPane, "Bạn có muốn đăng xuất không?");
				
				if (choice == JOptionPane.YES_OPTION) {
					setVisible(false);
					dispose();
					new LoginScreen();
				}
			}
		});
		
		JLabel lblInformation = new JLabel("Hệ thống được phát triển bởi tác giả Đinh Trần Xuân Thi");
		lblInformation.setForeground(new Color(25, 25, 112));
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformation.setBounds(405, 579, 382, 24);
		contentPane.add(lblInformation);
		
		mainPane = new JPanel();
		mainPane.setBackground(new Color(255, 255, 255));
		mainPane.setBounds(204, 70, 960, 490);
		contentPane.add(mainPane);
		
		cardLayout = new CardLayout();
		mainPane.setLayout(cardLayout);
		
		attendancePane = new AttendancePanel();
		attendancePane.setStudent(student);
		accountPane = new AccountPanel();
		accountPane.setStudentAccount(student);
		coursesContainerPane = new CoursesContainerPanel(student.getStudentId());
		changePasswordPane = new ChangePasswordPanel("student", student.getStudentId());
		
		mainPane.add(coursesContainerPane, "courses-container");
		mainPane.add(attendancePane, "attendance");
		mainPane.add(accountPane, "account");
		mainPane.add(changePasswordPane, "password");
		
		if (student.getLastChangePassword() == null) {
			resetPanes();
			txtAccountPane.setBackground(THIRD_COLOR);
			lblAccount.setForeground(Color.WHITE);
			cardLayout.show(mainPane, "account");
			showChangePassword();
			
		}
		else {
			cardLayout.show(mainPane, "courses-container");
		}
		
		this.setVisible(true);
	}
	
	private void resetPanes() {
		txtCoursePane.setBackground(FIRST_COLOR);
		txtAttendancePane.setBackground(FIRST_COLOR);
		txtAccountPane.setBackground(FIRST_COLOR);
		
		lblCourse.setForeground(SECOND_COLOR);
		lblAttendance.setForeground(SECOND_COLOR);
		lblAccount.setForeground(SECOND_COLOR);
	}
	
	public void showCoursesContainer() {
		cardLayout.show(mainPane, "courses-container");
	}
	
	public void showChangePassword() {
		cardLayout.show(mainPane, "password");
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void showCourses() {
		coursesContainerPane.showCourses();
	}
	
	public void showCourse(StudentCourse studentCourse) {
		coursesContainerPane.showCourse(studentCourse);
	}
	
	public void showAttendanceResult(List<Attendance> attendanceList) {
		coursesContainerPane.showAttendanceResult(attendanceList);
	}
	
	
}
