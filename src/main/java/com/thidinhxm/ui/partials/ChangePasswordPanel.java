package com.thidinhxm.ui.partials;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.thidinhxm.daos.StaffDAO;
import com.thidinhxm.daos.StudentDAO;
import com.thidinhxm.entities.Staff;
import com.thidinhxm.entities.Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class ChangePasswordPanel extends JPanel {
	private JTextField txtPassword;
	private JTextField txtNewPassword;
	private JTextField txtConfirmNewPassword;
	private JPasswordField inputPassword;
	private JPasswordField inputNewPassword;
	private JPasswordField inputConfirmNewPassword;
	
	private String typeAccount;
	private String id;
	private JButton btnChangePassword;
	public ChangePasswordPanel(String typeAccount, String id) {
		setBackground(new Color(255, 255, 255));
		this.id = id;
		this.typeAccount = typeAccount;
		setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setText("Mật khẩu cũ");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(new Color(25, 25, 112));
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(166, 103, 180, 39);
		add(txtPassword);
		
		txtNewPassword = new JTextField();
		txtNewPassword.setText("Mật khẩu mới");
		txtNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPassword.setForeground(new Color(25, 25, 112));
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNewPassword.setEditable(false);
		txtNewPassword.setColumns(10);
		txtNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtNewPassword.setBackground(Color.WHITE);
		txtNewPassword.setBounds(166, 220, 180, 39);
		add(txtNewPassword);
		
		btnChangePassword = new JButton("Thay đổi mật khẩu");
		btnChangePassword.setForeground(Color.WHITE);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChangePassword.setBackground(new Color(25, 25, 112));
		btnChangePassword.setBounds(367, 418, 186, 39);
		btnChangePassword.addActionListener(new ActionListener( ) {

			public void actionPerformed(ActionEvent e) {
					handleClickBtnChangePassword();
			}
			
		});
		add(btnChangePassword);
		
		txtConfirmNewPassword = new JTextField();
		txtConfirmNewPassword.setText("Xác nhận mật khẩu");
		txtConfirmNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtConfirmNewPassword.setForeground(new Color(25, 25, 112));
		txtConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmNewPassword.setEditable(false);
		txtConfirmNewPassword.setColumns(10);
		txtConfirmNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtConfirmNewPassword.setBackground(Color.WHITE);
		txtConfirmNewPassword.setBounds(166, 337, 180, 39);
		add(txtConfirmNewPassword);
		
		JLabel lblTitle = new JLabel("Thay đổi mật khẩu");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(335, 24, 277, 49);
		add(lblTitle);
		
		inputPassword = new JPasswordField("");
		inputPassword.setForeground(new Color(25, 25, 112));
		inputPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputPassword.setBounds(366, 103, 430, 39);
		add(inputPassword);
		
		inputNewPassword = new JPasswordField("");
		inputNewPassword.setForeground(new Color(25, 25, 112));
		inputNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputNewPassword.setBounds(366, 220, 430, 39);
		add(inputNewPassword);
		
		inputConfirmNewPassword = new JPasswordField("");
		inputConfirmNewPassword.setForeground(new Color(25, 25, 112));
		inputConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputConfirmNewPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputConfirmNewPassword.setBounds(366, 337, 430, 39);
		add(inputConfirmNewPassword);
	}
	
	private void handleClickBtnChangePassword() {
		String password = new String(inputPassword.getPassword());
		String newPassword = new String(inputNewPassword.getPassword());
		String confirmNewPassword = new String(inputConfirmNewPassword.getPassword());
		
		if (password.length() == 0 || newPassword.length() == 0 || confirmNewPassword.length() ==0) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
		}
		
		else if (!newPassword.equals(confirmNewPassword)) {
			JOptionPane.showMessageDialog(this, "Nhập mật khẩu không khớp!");
		}
		
		else if (typeAccount == "student") {
			if (StudentDAO.checkPassword(id, password)) {
				StudentDAO.changePassword(id, newPassword);
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
			}
			else {
				JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng!");
			}
		}
		else {
			if (StaffDAO.checkPassword(id, password)) {
				StaffDAO.changePassword(id, newPassword);
				JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
			}
			else {
				JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng!");
			}
		}
	}
	
	
}
