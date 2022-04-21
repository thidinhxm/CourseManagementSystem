package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AddSubjectPanel extends JPanel {
	private JTextField txtSubjectId;
	private JTextField inputSubjectId;
	private JTextField txtSubjectName;
	private JTextField inputSubjectName;
	private JTextField txtSubjectCredit;
	private JTextField inputSubjectCredit;
	private JLabel lblTitle;
	private JButton btnAdd;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public AddSubjectPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		txtSubjectId = new JTextField();
		txtSubjectId.setText("Mã môn học");
		txtSubjectId.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubjectId.setForeground(new Color(25, 25, 112));
		txtSubjectId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubjectId.setEditable(false);
		txtSubjectId.setColumns(10);
		txtSubjectId.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtSubjectId.setBackground(Color.WHITE);
		txtSubjectId.setBounds(205, 95, 125, 39);
		add(txtSubjectId);
		
		inputSubjectId = new JTextField();
		inputSubjectId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputSubjectId.setForeground(new Color(25, 25, 112));
		inputSubjectId.setColumns(10);
		inputSubjectId.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputSubjectId.setBounds(350, 97, 430, 39);
		add(inputSubjectId);
		
		txtSubjectName = new JTextField();
		txtSubjectName.setText("Tên môn học");
		txtSubjectName.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubjectName.setForeground(new Color(25, 25, 112));
		txtSubjectName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubjectName.setEditable(false);
		txtSubjectName.setColumns(10);
		txtSubjectName.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtSubjectName.setBackground(Color.WHITE);
		txtSubjectName.setBounds(205, 182, 125, 39);
		add(txtSubjectName);
		
		inputSubjectName = new JTextField();
		inputSubjectName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputSubjectName.setForeground(new Color(25, 25, 112));
		inputSubjectName.setColumns(10);
		inputSubjectName.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputSubjectName.setBounds(350, 182, 430, 39);
		add(inputSubjectName);
		
		txtSubjectCredit = new JTextField();
		txtSubjectCredit.setText("Số tín chỉ");
		txtSubjectCredit.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubjectCredit.setForeground(new Color(25, 25, 112));
		txtSubjectCredit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubjectCredit.setEditable(false);
		txtSubjectCredit.setColumns(10);
		txtSubjectCredit.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtSubjectCredit.setBackground(Color.WHITE);
		txtSubjectCredit.setBounds(205, 268, 125, 39);
		add(txtSubjectCredit);
		
		inputSubjectCredit = new JTextField();
		inputSubjectCredit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputSubjectCredit.setForeground(new Color(25, 25, 112));
		inputSubjectCredit.setColumns(10);
		inputSubjectCredit.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputSubjectCredit.setBounds(350, 268, 430, 39);
		add(inputSubjectCredit);
		
		lblTitle = new JLabel("Thêm môn học");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(332, 25, 236, 39);
		add(lblTitle);
		
		btnAdd = new JButton("Thêm môn học");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(314, 356, 151, 39);
		add(btnAdd);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(518, 356, 151, 39);
		add(btnBack);

	}
}
