package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;

import com.thidinhxm.daos.SubjectDAO;
import com.thidinhxm.entities.Subject;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

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
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				handleBtnAddClick();	
			}
			
		});
		add(btnAdd);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(518, 356, 151, 39);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				backToSubjects();	
			}
			
		});
		add(btnBack);

	}
	
	private void backToSubjects() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showSubjects();
	}
	
	public void handleBtnAddClick() {
		String subjectId = inputSubjectId.getText();
		String subjectName = inputSubjectName.getText();
		String subjectCredit = inputSubjectCredit.getText();
		
		if (subjectId.equals("") || subjectName.equals("") || subjectCredit.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
		}
		else if (SubjectDAO.getSubjectById(subjectId) != null) {
			JOptionPane.showMessageDialog(this, "Mã môn học đã tồn tại");
		}
		else if (!subjectCredit.matches("[0-4]") ) {
			JOptionPane.showMessageDialog(this, "Số tín chỉ phải là số và có giá trị từ 1 đến 4");
		}
		else {
			Subject subject = new Subject(subjectId, subjectName, Integer.parseInt(subjectCredit));
			Boolean check = SubjectDAO.addSubject(subject);
			if (check) {
				JOptionPane.showMessageDialog(this, "Thêm môn học thành công");
				StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
				screen.viewAfterAddSubject();
			}
			else {
				JOptionPane.showMessageDialog(this, "Thêm môn học thất bại");
			}
		}
	}
}
