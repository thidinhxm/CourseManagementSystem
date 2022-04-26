package com.thidinhxm.ui.staff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.daos.StudentCourseDAO;
import com.thidinhxm.daos.StudentDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.entities.AttendanceId;
import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.Student;
import com.thidinhxm.entities.StudentCourse;
import com.thidinhxm.utils.DateLabelFormatter;
import javax.swing.JComboBox;

public class AddNewStudentPanel extends JPanel {
	private JTextField txtId;
	private JTextField inputId;
	private JTextField txtFullname;
	private JTextField inputFullname;
	private JTextField txtDateOfBirth;
	private JTextField txtGender;
	
	private Course course;
	private JLabel lblTitle;
	private JButton btnAdd;
	private Properties p;
	private JDatePanelImpl dateOfBirthPanel;
	private UtilDateModel modelDateOfBirth;
	private JDatePickerImpl datePickerDateOfBirth;
	private SpringLayout springLayoutDateOfBirth;
	private JComboBox<String> comboBoxGender;
	private JButton btnBack;
	public AddNewStudentPanel() {
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		lblTitle = new JLabel("Thêm sinh viên mới");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(28, 0, 711, 49);
		add(lblTitle);
		
		txtId = new JTextField();
		txtId.setText("MSSV");
		txtId.setHorizontalAlignment(SwingConstants.CENTER);
		txtId.setForeground(new Color(25, 25, 112));
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtId.setBackground(Color.WHITE);
		txtId.setBounds(174, 79, 125, 39);
		add(txtId);
		
		inputId = new JTextField();
		inputId.setForeground(new Color(25, 25, 112));
		inputId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputId.setColumns(10);
		inputId.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputId.setBackground(Color.WHITE);
		inputId.setBounds(319, 79, 288, 39);
		add(inputId);
		
		txtFullname = new JTextField();
		txtFullname.setText("Họ và tên");
		txtFullname.setHorizontalAlignment(SwingConstants.CENTER);
		txtFullname.setForeground(new Color(25, 25, 112));
		txtFullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFullname.setEditable(false);
		txtFullname.setColumns(10);
		txtFullname.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtFullname.setBackground(Color.WHITE);
		txtFullname.setBounds(174, 162, 125, 39);
		add(txtFullname);
		
		inputFullname = new JTextField();
		inputFullname.setForeground(new Color(25, 25, 112));
		inputFullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputFullname.setColumns(10);
		inputFullname.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputFullname.setBackground(Color.WHITE);
		inputFullname.setBounds(319, 162, 288, 39);
		add(inputFullname);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setText("Ngày sinh");
		txtDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateOfBirth.setForeground(new Color(25, 25, 112));
		txtDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateOfBirth.setEditable(false);
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateOfBirth.setBackground(Color.WHITE);
		txtDateOfBirth.setBounds(174, 240, 125, 39);
		add(txtDateOfBirth);
		
		modelDateOfBirth = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		dateOfBirthPanel = new JDatePanelImpl(modelDateOfBirth, p);
		datePickerDateOfBirth = new JDatePickerImpl(dateOfBirthPanel, new DateLabelFormatter());
		datePickerDateOfBirth.setBackground(new Color(255, 255, 255));
		
		springLayoutDateOfBirth = (SpringLayout) datePickerDateOfBirth.getLayout();
		springLayoutDateOfBirth.putConstraint(SpringLayout.NORTH, datePickerDateOfBirth.getJFormattedTextField(), -25, SpringLayout.SOUTH, datePickerDateOfBirth);
		springLayoutDateOfBirth.putConstraint(SpringLayout.SOUTH, datePickerDateOfBirth.getJFormattedTextField(), 12, SpringLayout.SOUTH, datePickerDateOfBirth);
		datePickerDateOfBirth.setSize(316, 39);
		datePickerDateOfBirth.setLocation(319, 240);
		datePickerDateOfBirth.getJFormattedTextField().setForeground(new Color(25, 25, 112));
		datePickerDateOfBirth.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		datePickerDateOfBirth.getJFormattedTextField().setBorder(new LineBorder(new Color(25, 25, 112)));
		datePickerDateOfBirth.getJFormattedTextField().setBackground(Color.WHITE);
		add(datePickerDateOfBirth);
		
		txtGender = new JTextField();
		txtGender.setText("Giới tính");
		txtGender.setHorizontalAlignment(SwingConstants.CENTER);
		txtGender.setForeground(new Color(25, 25, 112));
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setEditable(false);
		txtGender.setColumns(10);
		txtGender.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtGender.setBackground(Color.WHITE);
		txtGender.setBounds(174, 313, 125, 39);
		add(txtGender);
		
		comboBoxGender = new JComboBox<String>();
		comboBoxGender.setForeground(new Color(25, 25, 112));
		comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxGender.setBackground(Color.WHITE);
		comboBoxGender.setBounds(319, 313, 288, 39);
		add(comboBoxGender);
		
		comboBoxGender.addItem("Nam");
		comboBoxGender.addItem("Nữ");
		
		btnAdd = new JButton("Thêm sinh viên");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(196, 422, 154, 39);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				handleBtnAddClick();
			}
			
		});
		add(btnAdd);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(406, 421, 154, 39);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				backToCourse();	
			}
			
		});
		

	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setTitle() {
		lblTitle.setText("Thêm mới sinh viên vào khóa " + course.getCourseName());;
	}
	
	private void handleBtnAddClick() {
		String id = inputId.getText();
		String name = inputFullname.getText();
		String dateOfBirth = datePickerDateOfBirth.getJFormattedTextField().getText(); 
		String gender = comboBoxGender.getSelectedItem() + "";
		if (id.equals("") || name.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ các trường");
		}
		else if (StudentDAO.getStudentById(id) != null) {
				JOptionPane.showMessageDialog(this, "Mã sinh viên này đã tồn tại");
		}	
		else {
			Student student = new Student(id, id, id, name, LocalDate.parse(dateOfBirth), gender);
			Boolean check = StudentDAO.addStudent(student);
			if (check) {
				StudentCourse studentCourse = new StudentCourse(student, course);
				StudentCourseDAO.addStudentToCourse(studentCourse);
				for (int i = 1; i <= 15; i++) {
					AttendanceId attendanceId = new AttendanceId(studentCourse.getStudentCourseId(), i);
					Attendance attendance = new Attendance(attendanceId, studentCourse);
					AttendanceDAO.addAttendance(attendance);
					
				}
				JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
			}
			else {
				JOptionPane.showMessageDialog(this, "Thêm sinh viên thất bại");
			}
		}
	}
	
	private void backToCourse() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showCourse(course);
	}
}
