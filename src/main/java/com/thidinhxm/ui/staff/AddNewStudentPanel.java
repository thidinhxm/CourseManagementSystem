package com.thidinhxm.ui.staff;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.thidinhxm.entities.Course;

public class AddNewStudentPanel extends JPanel {
	private JTextField txtId;
	private JTextField inputId;
	private JTextField txtFullname;
	private JTextField inputFullname;
	private JTextField txtDateOfBirth;
	private JTextField inputDateOfBirth;
	private JTextField txtGender;
	private JTextField inputGender;
	
	private Course course;
	private JLabel lblTitle;
	private JButton btnAdd;
	public AddNewStudentPanel() {
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		lblTitle = new JLabel("Thêm sinh viên mới");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(28, 0, 711, 49);
		add(lblTitle);
		
		btnAdd = new JButton("Thêm sinh viên");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(294, 418, 154, 39);
		add(btnAdd);
		
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
		
		inputDateOfBirth = new JTextField();
		inputDateOfBirth.setForeground(new Color(25, 25, 112));
		inputDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputDateOfBirth.setColumns(10);
		inputDateOfBirth.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputDateOfBirth.setBackground(Color.WHITE);
		inputDateOfBirth.setBounds(319, 240, 288, 39);
		add(inputDateOfBirth);
		
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
		
		inputGender = new JTextField();
		inputGender.setForeground(new Color(25, 25, 112));
		inputGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputGender.setColumns(10);
		inputGender.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputGender.setBackground(Color.WHITE);
		inputGender.setBounds(319, 313, 288, 39);
		add(inputGender);
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setTitle() {
		lblTitle.setText("Thêm mới sinh viên vào khóa " + course.getCourseName());;
	}
}
