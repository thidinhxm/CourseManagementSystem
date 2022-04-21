package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class AddStudentPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AddStudentPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 10, 170, 470);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblChooseStudent = new JLabel("Ch\u1ECDn sinh vi\u00EAn");
		lblChooseStudent.setVerticalAlignment(SwingConstants.CENTER);
		lblChooseStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseStudent.setForeground(new Color(25, 25, 112));
		lblChooseStudent.setFont(new Font("Dialog", Font.BOLD, 16));
		lblChooseStudent.setBounds(0, 59, 170, 41);
		panel.add(lblChooseStudent);
		
		JLabel lblAddNewStudent = new JLabel("Th\u00EAm sinh vi\u00EAn m\u1EDBi");
		lblAddNewStudent.setVerticalAlignment(SwingConstants.CENTER);
		lblAddNewStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewStudent.setForeground(new Color(25, 25, 112));
		lblAddNewStudent.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddNewStudent.setBounds(0, 203, 170, 41);
		panel.add(lblAddNewStudent);
		
		JLabel lblAddFromFile = new JLabel("Th\u00EAm t\u1EEB file");
		lblAddFromFile.setVerticalAlignment(SwingConstants.CENTER);
		lblAddFromFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddFromFile.setForeground(new Color(25, 25, 112));
		lblAddFromFile.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddFromFile.setBounds(0, 366, 170, 41);
		panel.add(lblAddFromFile);
		
		JPanel containPane = new JPanel();
		containPane.setBounds(193, 10, 767, 470);
		add(containPane);
		containPane.setLayout(new CardLayout(0, 0));
		
		ImportStudentPanel pn = new ImportStudentPanel();
		containPane.add(pn);

	}

}
