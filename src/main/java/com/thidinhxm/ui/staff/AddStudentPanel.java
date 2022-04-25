package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class AddStudentPanel extends JPanel {

	private ChooseStudentPanel chooseStudentPane;
	private AddNewStudentPanel addNewStudentPane;
	private ImportStudentPanel importStudentPane;
	private JPanel mainPane;
	private JLabel lblAddFromFile;
	private JPanel txtChooseStudentPane;
	private JLabel lblChooseStudent;
	private JPanel txtAddNewStudentPane;
	private JLabel lblAddNewStudent;
	private Container txtAddFromFilePane;
	private JPanel titlePane;
	private CardLayout cardLayout;
	
	private static final Color FIRST_COLOR = new Color(248, 248, 255);
	private static final Color SECOND_COLOR = new Color(25, 25, 112);
	private static final Color THIRD_COLOR = new Color(0, 0, 205);

	public AddStudentPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		titlePane = new JPanel();
		titlePane.setBackground(new Color(248, 248, 255));
		titlePane.setBounds(10, 10, 170, 470);
		add(titlePane);
		titlePane.setLayout(null);
		
		txtChooseStudentPane = new JPanel();
		txtChooseStudentPane.setBackground(THIRD_COLOR);
		txtChooseStudentPane.setBounds(0, 66, 170, 41);
		titlePane.add(txtChooseStudentPane);
		txtChooseStudentPane.setLayout(null);
		
		lblChooseStudent = new JLabel("Chọn sinh viên");
		lblChooseStudent.setBounds(0, 0, 170, 41);
		txtChooseStudentPane.add(lblChooseStudent);
		lblChooseStudent.setVerticalAlignment(SwingConstants.CENTER);
		lblChooseStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseStudent.setForeground(Color.WHITE);
		lblChooseStudent.setFont(new Font("Dialog", Font.BOLD, 16));
		lblChooseStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPane();
				lblChooseStudent.setForeground(Color.WHITE);
				txtChooseStudentPane.setBackground(THIRD_COLOR);
				cardLayout.show(mainPane, "choose-student");
				
			}
		});
		
		txtAddNewStudentPane = new JPanel();
		txtAddNewStudentPane.setLayout(null);
		txtAddNewStudentPane.setBackground(new Color(248, 248, 255));
		txtAddNewStudentPane.setBounds(0, 213, 170, 41);
		titlePane.add(txtAddNewStudentPane);
		
		lblAddNewStudent = new JLabel("Thêm sinh viên mới");
		lblAddNewStudent.setBounds(0, 0, 170, 41);
		txtAddNewStudentPane.add(lblAddNewStudent);
		lblAddNewStudent.setVerticalAlignment(SwingConstants.CENTER);
		lblAddNewStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewStudent.setForeground(new Color(25, 25, 112));
		lblAddNewStudent.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddNewStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPane();
				lblAddNewStudent.setForeground(Color.WHITE);
				txtAddNewStudentPane.setBackground(THIRD_COLOR);
				cardLayout.show(mainPane, "new-student");
				
			}
		});
		
		txtAddFromFilePane = new JPanel();
		txtAddFromFilePane.setLayout(null);
		txtAddFromFilePane.setBackground(new Color(248, 248, 255));
		txtAddFromFilePane.setBounds(0, 363, 170, 41);
		titlePane.add(txtAddFromFilePane);
		
		lblAddFromFile = new JLabel("Thêm từ file");
		lblAddFromFile.setBounds(0, 0, 170, 41);
		txtAddFromFilePane.add(lblAddFromFile);
		lblAddFromFile.setVerticalAlignment(SwingConstants.CENTER);
		lblAddFromFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddFromFile.setForeground(new Color(25, 25, 112));
		lblAddFromFile.setFont(new Font("Dialog", Font.BOLD, 16));
		lblAddFromFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPane();
				lblAddFromFile.setForeground(Color.WHITE);
				txtAddFromFilePane.setBackground(THIRD_COLOR);
				cardLayout.show(mainPane, "import-student");
				
			}
		});
		
		mainPane = new JPanel();
		mainPane.setBounds(193, 10, 757, 470);
		
		add(mainPane);
		
		cardLayout = new CardLayout();
		mainPane.setLayout(cardLayout);
		
		chooseStudentPane = new ChooseStudentPanel();
		addNewStudentPane = new AddNewStudentPanel();
		importStudentPane = new ImportStudentPanel();
		
		mainPane.add(chooseStudentPane, "choose-student");
		mainPane.add(addNewStudentPane, "new-student");
		mainPane.add(importStudentPane, "import-student");
		
		cardLayout.show(mainPane, "choose-student");
	}
	
	public void resetPane() {
		txtChooseStudentPane.setBackground(FIRST_COLOR);
		txtAddNewStudentPane.setBackground(FIRST_COLOR);
		txtAddFromFilePane.setBackground(FIRST_COLOR);
		
		lblChooseStudent.setForeground(SECOND_COLOR);
		lblAddNewStudent.setForeground(SECOND_COLOR);
		lblAddFromFile.setForeground(SECOND_COLOR);
	}
}
