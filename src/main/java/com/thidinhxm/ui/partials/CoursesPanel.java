package com.thidinhxm.ui.partials;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CoursesPanel extends JPanel {
	private JTable tableCourse;
	private JTextField txtCourse;
	private JTextField inputCourse;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public CoursesPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Các khóa học của tôi");
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(370, 5, 236, 39);
		add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 101, 900, 375);
		add(scrollPane);
		
		tableCourse = new JTable();
		tableCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableCourse.setForeground(new Color(25, 25, 112));
		tableCourse.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		tableCourse.getTableHeader().setBackground(new Color(25, 25, 112));
		tableCourse.getTableHeader().setForeground(Color.WHITE);
		tableCourse.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "Tên khóa học", "Bắt đầu", "Kết thúc", "Ngày học", "Từ", "Đến"
			}
		));
		tableCourse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCourse.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableCourse.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableCourse.getColumnModel().getColumn(2).setPreferredWidth(70);
		tableCourse.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableCourse.getColumnModel().getColumn(4).setPreferredWidth(70);
		tableCourse.getColumnModel().getColumn(5).setPreferredWidth(50);
		tableCourse.getColumnModel().getColumn(6).setPreferredWidth(50);
		tableCourse.setRowHeight(25);
		scrollPane.setViewportView(tableCourse);
		
		txtCourse = new JTextField();
		txtCourse.setHorizontalAlignment(SwingConstants.CENTER);
		txtCourse.setForeground(new Color(25, 25, 112));
		txtCourse.setBackground(new Color(255, 255, 255));
		txtCourse.setEditable(false);
		txtCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCourse.setText("Tên khóa học");
		txtCourse.setBounds(35, 48, 125, 39);
		txtCourse.setBorder(new LineBorder(new Color(25, 25, 112)));
		add(txtCourse);
		txtCourse.setColumns(10);
		
		inputCourse = new JTextField();
		inputCourse.setForeground(new Color(25, 25, 112));
		inputCourse.setColumns(10);
		inputCourse.setBounds(180, 48, 620, 39);
		inputCourse.setBorder(new LineBorder(new Color(25, 25, 112)));
		add(inputCourse);
		
		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(25, 25, 112));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(820, 48, 115, 39);
		add(btnSearch);
		
		
	}
}
