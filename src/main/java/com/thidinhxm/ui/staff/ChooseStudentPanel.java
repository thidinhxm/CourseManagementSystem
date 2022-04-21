package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class ChooseStudentPanel extends JPanel {
	private JTable tableStudent;
	private JTextField txtStudent;
	private JTextField inputStudent;

	/**
	 * Create the panel.
	 */
	public ChooseStudentPanel() {
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Danh sách sinh viên");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(280, 0, 201, 49);
		add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 117, 733, 289);
		add(scrollPane);
		
		tableStudent = new JTable();
		tableStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableStudent.setForeground(new Color(25, 25, 112));
		tableStudent.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		tableStudent.getTableHeader().setBackground(new Color(25, 25, 112));
		tableStudent.getTableHeader().setForeground(Color.WHITE);
		tableStudent.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"STT", "MSSV", "Họ và tên", "Chọn"
			}
		));
		tableStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableStudent.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableStudent.getColumnModel().getColumn(1).setPreferredWidth(70);
		tableStudent.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableStudent.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableStudent.setRowHeight(25);
		scrollPane.setViewportView(tableStudent);
		
		JButton btnAdd = new JButton("Thêm sinh viên");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(294, 418, 154, 39);
		add(btnAdd);
		
		txtStudent = new JTextField();
		txtStudent.setText("Sinh viên");
		txtStudent.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudent.setForeground(new Color(25, 25, 112));
		txtStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtStudent.setEditable(false);
		txtStudent.setColumns(10);
		txtStudent.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtStudent.setBackground(Color.WHITE);
		txtStudent.setBounds(17, 57, 125, 39);
		add(txtStudent);
		
		inputStudent = new JTextField();
		inputStudent.setForeground(new Color(25, 25, 112));
		inputStudent.setColumns(10);
		inputStudent.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputStudent.setBounds(166, 57, 444, 39);
		add(inputStudent);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(new Color(25, 25, 112));
		btnSearch.setBounds(635, 57, 115, 39);
		add(btnSearch);

	}
}
