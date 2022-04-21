package com.thidinhxm.ui.student;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class AttendancePanel extends JPanel {
	private JTable tableAttendance;

	/**
	 * Create the panel.
	 */
	public AttendancePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Kết quả điểm danh");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(370, 10, 228, 29);
		add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 56, 907, 407);
		add(scrollPane);
		
		tableAttendance = new JTable();
		tableAttendance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableAttendance.setForeground(new Color(25, 25, 112));
		tableAttendance.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		tableAttendance.getTableHeader().setBackground(new Color(25, 25, 112));
		tableAttendance.getTableHeader().setForeground(Color.WHITE);
		tableAttendance.setModel(new DefaultTableModel(
			new Object[][] {
				{"Tuần 1", null, null, null},
				{"Tuần 2", null, null, null},
				{"Tuần 3", null, null, null},
				{"Tuần 4", null, null, null},
				{"Tuần 5", null, null, null},
				{"Tuần 6", null, null, null},
				{"Tuần 7", null, null, null},
				{"Tuần 8", null, null, null},
				{"Tuần 9", null, null, null},
				{"Tuần 10", null, null, null},
				{"Tuần 11", null, null, null},
				{"Tuần 12", null, null, null},
				{"Tuần 13", null, null, null},
				{"Tuần 14", null, null, null},
				{"Tuần 15", null, null, null},
			},
			new String[] {
				"Lo\u1EA1i", "C\u00F3 m\u1EB7t", "V\u1EAFng m\u1EB7t", "Ch\u01B0a c\u00F3 d\u1EEF li\u00EAu"
			}
		));
		tableAttendance.setRowHeight(25);
		scrollPane.setViewportView(tableAttendance);

	}
}
