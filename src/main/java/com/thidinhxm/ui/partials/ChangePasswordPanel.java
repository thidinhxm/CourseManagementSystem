package com.thidinhxm.ui.partials;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ChangePasswordPanel extends JPanel {
	private JTextField txtPassword;
	private JTextField inputPassword;
	private JTextField txtConfirmPassword;
	private JTextField inputConfirmPassword;
	private JTextField txtNewPassword;
	private JTextField inputNewPassword;
	private JTextField txtConfirmNewPassword;
	private JTextField inputConfirmNewPassword;

	/**
	 * Create the panel.
	 */
	public ChangePasswordPanel() {
		setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setText("M\u1EADt kh\u1EA9u c\u0169");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(new Color(25, 25, 112));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(166, 103, 180, 39);
		add(txtPassword);
		
		inputPassword = new JTextField();
		inputPassword.setForeground(new Color(25, 25, 112));
		inputPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputPassword.setColumns(10);
		inputPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputPassword.setBounds(366, 105, 430, 39);
		add(inputPassword);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setText("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u");
		txtConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmPassword.setForeground(new Color(25, 25, 112));
		txtConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmPassword.setEditable(false);
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtConfirmPassword.setBackground(Color.WHITE);
		txtConfirmPassword.setBounds(166, 182, 180, 39);
		add(txtConfirmPassword);
		
		inputConfirmPassword = new JTextField();
		inputConfirmPassword.setForeground(new Color(25, 25, 112));
		inputConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputConfirmPassword.setColumns(10);
		inputConfirmPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputConfirmPassword.setBounds(366, 182, 430, 39);
		add(inputConfirmPassword);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setText("M\u1EADt kh\u1EA9u m\u1EDBi");
		txtNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPassword.setForeground(new Color(25, 25, 112));
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNewPassword.setEditable(false);
		txtNewPassword.setColumns(10);
		txtNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtNewPassword.setBackground(Color.WHITE);
		txtNewPassword.setBounds(166, 260, 180, 39);
		add(txtNewPassword);
		
		inputNewPassword = new JTextField();
		inputNewPassword.setForeground(new Color(25, 25, 112));
		inputNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputNewPassword.setColumns(10);
		inputNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputNewPassword.setBounds(366, 260, 430, 39);
		add(inputNewPassword);
		
		JButton btnChangePassword = new JButton("Thay \u0111\u1ED5i m\u1EADt kh\u1EA9u");
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangePassword.setBackground(new Color(25, 25, 112));
		btnChangePassword.setBounds(367, 418, 186, 39);
		add(btnChangePassword);
		
		txtConfirmNewPassword = new JTextField();
		txtConfirmNewPassword.setText("X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u m\u1EDBi");
		txtConfirmNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmNewPassword.setForeground(new Color(25, 25, 112));
		txtConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmNewPassword.setEditable(false);
		txtConfirmNewPassword.setColumns(10);
		txtConfirmNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtConfirmNewPassword.setBackground(Color.WHITE);
		txtConfirmNewPassword.setBounds(166, 337, 180, 39);
		add(txtConfirmNewPassword);
		
		inputConfirmNewPassword = new JTextField();
		inputConfirmNewPassword.setForeground(new Color(25, 25, 112));
		inputConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputConfirmNewPassword.setColumns(10);
		inputConfirmNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputConfirmNewPassword.setBounds(366, 337, 430, 39);
		add(inputConfirmNewPassword);
		
		JLabel lblTitle = new JLabel("Thay \u0111\u1ED5i m\u1EADt kh\u1EA9u");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(352, 23, 201, 49);
		add(lblTitle);

	}

}
