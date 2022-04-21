package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CoursePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CoursePanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khoá học: ");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(67, 10, 195, 49);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 123, 838, 321);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setForeground(new Color(25, 25, 112));
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		table.getTableHeader().setBackground(new Color(25, 25, 112));
		table.getTableHeader().setForeground(Color.WHITE);
		table.setModel(new DefaultTableModel(
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
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"STT", "MSSV", "Họ và tên", "Điểm"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel lblDanhSchSinh = new JLabel("Danh s\u00E1ch sinh vi\u00EAn");
		lblDanhSchSinh.setForeground(new Color(25, 25, 112));
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSchSinh.setBounds(67, 57, 201, 49);
		add(lblDanhSchSinh);
		
		JButton btnThmSinhVin = new JButton("Th\u00EAm sinh vi\u00EAn");
		btnThmSinhVin.setForeground(Color.WHITE);
		btnThmSinhVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThmSinhVin.setBackground(new Color(25, 25, 112));
		btnThmSinhVin.setBounds(751, 63, 154, 39);
		add(btnThmSinhVin);

	}

}
