package com.thidinhxm.ui.staff;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.thidinhxm.daos.CourseDAO;
import com.thidinhxm.daos.SubjectDAO;
import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.Staff;
import com.thidinhxm.ui.partials.AccountPanel;
import com.thidinhxm.ui.partials.ChangePasswordPanel;
import com.thidinhxm.ui.partials.HeaderPanel;
import com.thidinhxm.ui.partials.LoginScreen;
import com.thidinhxm.ui.student.StudentScreen;

import java.awt.Color;

public class StaffScreen extends JFrame {

	private JPanel contentPane;
	private JPanel txtAccountPane;
	private JLabel lblAccount;
	private JLabel lblSubject;
	private JPanel txtCoursePane;
	private JLabel lblCourse;
	private JPanel txtLogOutPane;
	private JLabel lblLogOut;
	private JPanel txtSubjectPane;
	private CardLayout cardLayout;
	private CoursesContainerPanel coursesContainerPane;
	private SubjectsPanel subjectsPane;
	private AccountPanel accountPane;
	private JPanel mainPane;
	private ChangePasswordPanel changePasswordPane;
	private AddSubjectPanel addSubjectPane;
	
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
		txtAccountPane.setBounds(0, 102, 182, 41);
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
				showAccount();
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
				showSubjects();
			}
		});
		txtSubjectPane.add(lblSubject);
		
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
				showCourses();
				showCoursesContainer();
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
		txtLogOutPane.add(lblLogOut);
		
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
		
		coursesContainerPane = new CoursesContainerPanel();
		subjectsPane = new SubjectsPanel();
		accountPane = new AccountPanel();
		accountPane.setStaffAccount(staff);
		changePasswordPane = new ChangePasswordPanel("staff", staff.getStaffId());
		addSubjectPane = new AddSubjectPanel();
		
		mainPane.add(coursesContainerPane, "courses-container");
		mainPane.add(subjectsPane, "subjects");
		mainPane.add(accountPane, "account");
		mainPane.add(changePasswordPane, "password");
		mainPane.add(addSubjectPane, "add-subject");
		
		cardLayout.show(mainPane, "courses-container");
		
		setVisible(true);
	}
	
	private void resetPane() {
		txtCoursePane.setBackground(FIRST_COLOR);
		txtSubjectPane.setBackground(FIRST_COLOR);
		txtAccountPane.setBackground(FIRST_COLOR);
		
		lblCourse.setForeground(SECOND_COLOR);
		lblSubject.setForeground(SECOND_COLOR);
		lblAccount.setForeground(SECOND_COLOR);
	}
	
	public void showCoursesContainer() {
		cardLayout.show(mainPane, "courses-container");
	}
	
	public void showCourses() {
		coursesContainerPane.showCourses();
	}
	public void showCourse(Course course) {
		coursesContainerPane.showCourse(course);
	}
	public void showAddStudent() {
		coursesContainerPane.showAddStudent();
	}
	
	public void showAddCourse() {
		coursesContainerPane.showAddCourse();
	}
	
	public void showSubjects() {
		cardLayout.show(mainPane, "subjects");
	}
	
	public void showAccount() {
		cardLayout.show(mainPane, "account");
	}
	
	public void showChangePassword() {
		cardLayout.show(mainPane, "password");
	}
	
	public void showAddSubject() {
		cardLayout.show(mainPane, "add-subject");
	}
	
	public void viewAfterAddSubject() {
		subjectsPane.displayTable(SubjectDAO.getSubjects());
	}
	
	
}
