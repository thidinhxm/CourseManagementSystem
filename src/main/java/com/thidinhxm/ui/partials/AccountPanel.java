package com.thidinhxm.ui.partials;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.thidinhxm.entities.Staff;
import com.thidinhxm.entities.Student;
import com.thidinhxm.ui.staff.StaffScreen;
import com.thidinhxm.ui.student.StudentScreen;
import com.thidinhxm.utils.DateTimeUtil;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountPanel extends JPanel {
	private JTextField txtIdTitle;
	private JTextField txtId;
	private JTextField txtFullnameTitle;
	private JTextField txtFullname;
	private JTextField txtDateOfBirthTitle;
	private JTextField txtDateOfBirth;
	private JTextField txtGenderTitle;
	private JTextField txtGender;
	private JButton btnChangePassword;
	
	private String typeAccount;
	
	public AccountPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Tài khoản của bạn");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(338, 10, 236, 39);
		add(lblTitle);
		
		btnChangePassword = new JButton("Thay đổi mật khẩu");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToChangePassword();
			}
		});
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangePassword.setBackground(new Color(25, 25, 112));
		btnChangePassword.setBounds(368, 398, 194, 39);
		add(btnChangePassword);
		
		txtIdTitle = new JTextField();
		txtIdTitle.setText("Mã số");
		txtIdTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdTitle.setForeground(new Color(25, 25, 112));
		txtIdTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIdTitle.setEditable(false);
		txtIdTitle.setColumns(10);
		txtIdTitle.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtIdTitle.setBackground(Color.WHITE);
		txtIdTitle.setBounds(256, 74, 125, 39);
		add(txtIdTitle);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(255, 255, 255));
		txtId.setEditable(false);
		txtId.setForeground(new Color(25, 25, 112));
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtId.setBounds(401, 74, 288, 39);
		add(txtId);
		
		txtFullnameTitle = new JTextField();
		txtFullnameTitle.setText("Họ và tên");
		txtFullnameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtFullnameTitle.setForeground(new Color(25, 25, 112));
		txtFullnameTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFullnameTitle.setEditable(false);
		txtFullnameTitle.setColumns(10);
		txtFullnameTitle.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtFullnameTitle.setBackground(Color.WHITE);
		txtFullnameTitle.setBounds(256, 157, 125, 39);
		add(txtFullnameTitle);
		
		txtFullname = new JTextField();
		txtFullname.setBackground(new Color(255, 255, 255));
		txtFullname.setEditable(false);
		txtFullname.setForeground(new Color(25, 25, 112));
		txtFullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFullname.setColumns(10);
		txtFullname.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtFullname.setBounds(401, 157, 288, 39);
		add(txtFullname);
		
		txtDateOfBirthTitle = new JTextField();
		txtDateOfBirthTitle.setText("Ngày sinh");
		txtDateOfBirthTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateOfBirthTitle.setForeground(new Color(25, 25, 112));
		txtDateOfBirthTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateOfBirthTitle.setEditable(false);
		txtDateOfBirthTitle.setColumns(10);
		txtDateOfBirthTitle.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateOfBirthTitle.setBackground(Color.WHITE);
		txtDateOfBirthTitle.setBounds(256, 235, 125, 39);
		add(txtDateOfBirthTitle);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setBackground(new Color(255, 255, 255));
		txtDateOfBirth.setEditable(false);
		txtDateOfBirth.setForeground(new Color(25, 25, 112));
		txtDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateOfBirth.setBounds(401, 235, 288, 39);
		add(txtDateOfBirth);
		
		txtGenderTitle = new JTextField();
		txtGenderTitle.setText("Giới tính");
		txtGenderTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtGenderTitle.setForeground(new Color(25, 25, 112));
		txtGenderTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGenderTitle.setEditable(false);
		txtGenderTitle.setColumns(10);
		txtGenderTitle.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtGenderTitle.setBackground(Color.WHITE);
		txtGenderTitle.setBounds(256, 308, 125, 39);
		add(txtGenderTitle);
		
		txtGender = new JTextField();
		txtGender.setBackground(new Color(255, 255, 255));
		txtGender.setEditable(false);
		txtGender.setForeground(new Color(25, 25, 112));
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setColumns(10);
		txtGender.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtGender.setBounds(401, 308, 288, 39);
		add(txtGender);

	}
	
	public void setStudentAccount(Student student) {
		txtIdTitle.setText("Mã sinh viên");
		txtId.setText(student.getStudentId());
		txtFullname.setText(student.getFullname());
		txtDateOfBirth.setText(DateTimeUtil.getLocalDateString(student.getDateOfBirth()));
		txtGender.setText(student.getGender());
		typeAccount = "student";
	}
	
	public void setStaffAccount(Staff staff) {
		txtIdTitle.setText("Mã nhân viên");
		txtId.setText(staff.getStaffId());
		txtFullname.setText(staff.getFullname());
		txtDateOfBirth.setText(DateTimeUtil.getLocalDateString(staff.getDateOfBirth()));
		txtGender.setText(staff.getGender());
		typeAccount = "staff";
	}
	
	private void goToChangePassword() {
		if (typeAccount == "student") {
			StudentScreen screen = (StudentScreen) SwingUtilities.windowForComponent(this);
			screen.showChangePassword();
		}
		else {
			StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
			screen.showChangePassword();
		}
		
	}

	
}
