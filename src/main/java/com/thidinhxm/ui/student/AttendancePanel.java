package com.thidinhxm.ui.student;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.utils.DateTimeUtil;

import javax.swing.SwingConstants;

public class AttendancePanel extends JPanel {
	private JTable tableAttendance;
	private DefaultTableModel tableAttendanceModel;
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
		tableAttendance.setEnabled(false);
		tableAttendance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableAttendance.setForeground(new Color(25, 25, 112));
		tableAttendance.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		tableAttendance.getTableHeader().setBackground(new Color(25, 25, 112));
		tableAttendance.getTableHeader().setForeground(Color.WHITE);
		tableAttendance.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ngày", "Có mặt", "Vắng mặt", "Chưa có dữ liệu"
			}
		));
		tableAttendance.setRowHeight(25);
		scrollPane.setViewportView(tableAttendance);

	}
	
	public void displayAttendanceList(List<Attendance> attendanceList) {
		for (Attendance attendance : attendanceList) {
			if (attendance.getPresent() == null) {
				tableAttendanceModel.addRow(new Object[] {
						DateTimeUtil.getDateString(attendance.getAttendanceId().getDateLearn()),
						null,
						null,
						"X"
					});
			}
			else if (attendance.getPresent() == true) {
				tableAttendanceModel.addRow(new Object[] {
						DateTimeUtil.getDateString(attendance.getAttendanceId().getDateLearn()),
						"X",
						null,
						null
					});
			}
			else {
				tableAttendanceModel.addRow(new Object[] {
						DateTimeUtil.getDateString(attendance.getAttendanceId().getDateLearn()),
						null,
						"X",
						null
					});
			}
		}
	}
}
