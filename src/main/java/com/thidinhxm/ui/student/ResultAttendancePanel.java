package com.thidinhxm.ui.student;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.daos.StudentCourseDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.utils.DateTimeUtil;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultAttendancePanel extends JPanel {
	private JTable tableAttendance;
	private DefaultTableModel tableAttendanceModel;
	private JButton btnBack;
	
	private String studentId;
	private String courseId;
	public ResultAttendancePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Kết quả điểm danh");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(370, 0, 228, 36);
		add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 37, 907, 407);
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
				"Tuần", "Ngày", "Có mặt", "Vắng mặt", "Chưa có dữ liệu"
			}
		));
		tableAttendance.setRowHeight(25);
		tableAttendanceModel = (DefaultTableModel) tableAttendance.getModel();
		scrollPane.setViewportView(tableAttendance);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(343, 454, 255, 36);
		add(btnBack);

	}
	
	public void displayAttendanceList(List<Attendance> attendanceList) {
		tableAttendanceModel.setRowCount(0);
		for (Attendance attendance : attendanceList) {
			if (attendance.getPresent() == null) {
				tableAttendanceModel.addRow(new Object[] {
						tableAttendance.getRowCount() + 1 + "",
						DateTimeUtil.getLocalDateString(attendance.getAttendanceId().getDateLearn()),
						null,
						null,
						"X"
					});
			}
			else if (attendance.getPresent() == true) {
				tableAttendanceModel.addRow(new Object[] {
						tableAttendance.getRowCount() + 1 + "",
						DateTimeUtil.getLocalDateString(attendance.getAttendanceId().getDateLearn()),
						"X",
						null,
						null
					});
			}
			else {
				tableAttendanceModel.addRow(new Object[] {
						tableAttendance.getRowCount() + 1 + "",
						DateTimeUtil.getLocalDateString(attendance.getAttendanceId().getDateLearn()),
						null,
						"X",
						null
					});
			}
		}
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < tableAttendance.getColumnCount(); columnIndex++) {
        	tableAttendance.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
        
        final String studentId = attendanceList.get(0).getAttendanceId().getStudentCourseId().getStudentId();
        final Integer courseId = attendanceList.get(0).getAttendanceId().getStudentCourseId().getCourseId();
        
        for( ActionListener al : btnBack.getActionListeners() ) {
			btnBack.removeActionListener( al );
	    }
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToCourse(studentId, courseId);
			}
			
		});
        
	}
	
	private void backToCourse(String studentId, Integer courseId) {
		StudentScreen screen = (StudentScreen) SwingUtilities.windowForComponent(this);
		screen.showCourse(StudentCourseDAO.getStudentCourseByStudentCourseId(studentId, courseId));
	}
}
