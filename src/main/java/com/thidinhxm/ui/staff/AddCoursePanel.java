package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCoursePanel extends JPanel {
	private JTextField txtSubject;
	private JTextField inputSubject;
	private JTextField txtDateStart;
	private JTextField textField_3;
	private JTextField txtDateLearn;
	private JTextField textField_5;
	private JTextField txtDateEnd;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField txtRoom;
	private JTextField txtTimeStart;
	private JTextField textField_6;
	private JTextField txtTimeEnd;
	private JTextField textField_8;
	private JTextField txtCourseName;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public AddCoursePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Th\u00EAm kh\u00F3a h\u1ECDc");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(330, 10, 236, 39);
		add(lblTitle);
		
		txtSubject = new JTextField();
		txtSubject.setText("M\u00F4n h\u1ECDc");
		txtSubject.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubject.setForeground(new Color(25, 25, 112));
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubject.setEditable(false);
		txtSubject.setColumns(10);
		txtSubject.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtSubject.setBackground(Color.WHITE);
		txtSubject.setBounds(96, 78, 125, 39);
		add(txtSubject);
		
		inputSubject = new JTextField();
		inputSubject.setForeground(new Color(25, 25, 112));
		inputSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputSubject.setColumns(10);
		inputSubject.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputSubject.setBounds(241, 78, 627, 39);
		add(inputSubject);
		
		txtDateStart = new JTextField();
		txtDateStart.setText("Ng\u00E0y b\u1EAFt \u0111\u1EA7u");
		txtDateStart.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateStart.setForeground(new Color(25, 25, 112));
		txtDateStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateStart.setEditable(false);
		txtDateStart.setColumns(10);
		txtDateStart.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateStart.setBackground(Color.WHITE);
		txtDateStart.setBounds(96, 207, 125, 39);
		add(txtDateStart);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(25, 25, 112));
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField_3.setBounds(241, 207, 217, 39);
		add(textField_3);
		
		txtDateLearn = new JTextField();
		txtDateLearn.setText("Ng\u00E0y h\u1ECDc");
		txtDateLearn.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateLearn.setForeground(new Color(25, 25, 112));
		txtDateLearn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateLearn.setEditable(false);
		txtDateLearn.setColumns(10);
		txtDateLearn.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateLearn.setBackground(Color.WHITE);
		txtDateLearn.setBounds(96, 270, 125, 39);
		add(txtDateLearn);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(25, 25, 112));
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField_5.setBounds(241, 270, 217, 39);
		add(textField_5);
		
		JButton btnAdd = new JButton("Th\u00EAm kh\u00F3a h\u1ECDc");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(307, 412, 151, 39);
		add(btnAdd);
		
		JButton btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(506, 412, 151, 39);
		add(btnBack);
		
		txtDateEnd = new JTextField();
		txtDateEnd.setText("Ng\u00E0y k\u1EBFt th\u00FAc");
		txtDateEnd.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateEnd.setForeground(new Color(25, 25, 112));
		txtDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateEnd.setEditable(false);
		txtDateEnd.setColumns(10);
		txtDateEnd.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateEnd.setBackground(Color.WHITE);
		txtDateEnd.setBounds(506, 207, 125, 39);
		add(txtDateEnd);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(25, 25, 112));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField_2.setBounds(651, 207, 217, 39);
		add(textField_2);
		
		textField = new JTextField();
		textField.setForeground(new Color(25, 25, 112));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField.setBounds(651, 270, 217, 39);
		add(textField);
		
		txtRoom = new JTextField();
		txtRoom.setText("Ph\u00F2ng h\u1ECDc");
		txtRoom.setHorizontalAlignment(SwingConstants.CENTER);
		txtRoom.setForeground(new Color(25, 25, 112));
		txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRoom.setEditable(false);
		txtRoom.setColumns(10);
		txtRoom.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtRoom.setBackground(Color.WHITE);
		txtRoom.setBounds(506, 270, 125, 39);
		add(txtRoom);
		
		txtTimeStart = new JTextField();
		txtTimeStart.setText("T\u1EEB");
		txtTimeStart.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeStart.setForeground(new Color(25, 25, 112));
		txtTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimeStart.setEditable(false);
		txtTimeStart.setColumns(10);
		txtTimeStart.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtTimeStart.setBackground(Color.WHITE);
		txtTimeStart.setBounds(96, 330, 125, 39);
		add(txtTimeStart);
		
		textField_6 = new JTextField();
		textField_6.setForeground(new Color(25, 25, 112));
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField_6.setBounds(241, 330, 217, 39);
		add(textField_6);
		
		txtTimeEnd = new JTextField();
		txtTimeEnd.setText("\u0110\u1EBFn");
		txtTimeEnd.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeEnd.setForeground(new Color(25, 25, 112));
		txtTimeEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimeEnd.setEditable(false);
		txtTimeEnd.setColumns(10);
		txtTimeEnd.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtTimeEnd.setBackground(Color.WHITE);
		txtTimeEnd.setBounds(506, 330, 125, 39);
		add(txtTimeEnd);
		
		textField_8 = new JTextField();
		textField_8.setForeground(new Color(25, 25, 112));
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField_8.setBounds(651, 330, 217, 39);
		add(textField_8);
		
		txtCourseName = new JTextField();
		txtCourseName.setText("Tên khóa học");
		txtCourseName.setHorizontalAlignment(SwingConstants.CENTER);
		txtCourseName.setForeground(new Color(25, 25, 112));
		txtCourseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCourseName.setEditable(false);
		txtCourseName.setColumns(10);
		txtCourseName.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtCourseName.setBackground(Color.WHITE);
		txtCourseName.setBounds(96, 141, 125, 39);
		add(txtCourseName);
		
		textField_7 = new JTextField();
		textField_7.setForeground(new Color(25, 25, 112));
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField_7.setBounds(241, 141, 627, 39);
		add(textField_7);

	}

}
