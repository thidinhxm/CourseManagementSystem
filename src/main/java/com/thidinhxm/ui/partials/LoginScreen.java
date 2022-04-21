package com.thidinhxm.ui.partials;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField inputUsername;
	private JPasswordField inputPassword;
	private JTextField txtLogin;
	private JTextField txtPassword;
	private JTextField txtTypeUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Hệ thống quản lý sinh viên");
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitle.setBounds(115, 33, 382, 37);
		contentPane.add(lblTitle);
		
		JLabel lblImageLogo = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/images/logo.png"));
		lblImageLogo.setIcon(img);
		lblImageLogo.setBounds(150, 177, 248, 231);
		contentPane.add(lblImageLogo);
		
		JLabel lblInformation = new JLabel("Hệ thống được phát triển bởi tác giả Đinh Trần Xuân Thi");
		lblInformation.setForeground(new Color(25, 25, 112));
		lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInformation.setBounds(400, 579, 382, 24);
		contentPane.add(lblInformation);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(786, 458, 148, 37);
		contentPane.add(btnLogin);
		
		JLabel lblLogin = new JLabel("Đăng nhập");
		lblLogin.setForeground(new Color(25, 25, 112));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogin.setBounds(786, 146, 159, 37);
		contentPane.add(lblLogin);
		
		inputUsername = new JTextField();
		inputUsername.setForeground(new Color(25, 25, 112));
		inputUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputUsername.setColumns(10);
		inputUsername.setBounds(807, 249, 264, 37);
		inputUsername.setBorder(new LineBorder(new Color(25, 25, 112)));
		contentPane.add(inputUsername);
		
		inputPassword = new JPasswordField();
		inputPassword.setForeground(new Color(25, 25, 112));
		inputPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputPassword.setBounds(807, 320, 264, 37);
		inputPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		contentPane.add(inputPassword);
		
		txtLogin = new JTextField();
		txtLogin.setForeground(new Color(255, 255, 255));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setEditable(false);
		txtLogin.setBackground(new Color(25, 25, 112));
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLogin.setText("Tên đăng nhập");
		txtLogin.setBounds(625, 249, 159, 37);
		txtLogin.setBorder(new LineBorder(new Color(25, 25, 112)));
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setText("Mật khẩu");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPassword.setEditable(false);
		txtPassword.setColumns(10);
		txtPassword.setBackground(new Color(25, 25, 112));
		txtPassword.setBounds(625, 320, 159, 37);
		txtPassword.setBorder(new LineBorder(new Color(25, 25, 112)));
		contentPane.add(txtPassword);
		
		txtTypeUser = new JTextField();
		txtTypeUser.setText("Bạn là");
		txtTypeUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtTypeUser.setForeground(Color.WHITE);
		txtTypeUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTypeUser.setEditable(false);
		txtTypeUser.setColumns(10);
		txtTypeUser.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtTypeUser.setBackground(new Color(25, 25, 112));
		txtTypeUser.setBounds(625, 385, 159, 37);
		contentPane.add(txtTypeUser);
		
		JComboBox<String> comboBoxUserType = new JComboBox<String>();
		comboBoxUserType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxUserType.addItem("Học sinh");
		comboBoxUserType.addItem("Giáo vụ");
		
		comboBoxUserType.setForeground(new Color(25, 25, 112));
		comboBoxUserType.setBackground(new Color(255, 255, 255));
		comboBoxUserType.setBounds(807, 385, 264, 37);
		contentPane.add(comboBoxUserType);
		
		
		
	}
}
