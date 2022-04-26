package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.daos.StudentDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.Student;
import com.thidinhxm.entities.StudentCourseId;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ResultAttendancePanel extends JPanel {
	private JTable tableResultAttendance;
	private DefaultTableModel tableResultAttendanceModel;
	private JLabel lblTitle;
	private JButton btnUpdate;
	
	private Course course;
	private JButton btnBack;


	public ResultAttendancePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		lblTitle = new JLabel("Kết quả điểm danh khoá học ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(67, 0, 838, 49);
		add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 950, 343);
		add(scrollPane);
		
		tableResultAttendance = new JTable();
		tableResultAttendance.setCellSelectionEnabled(true);
		tableResultAttendance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableResultAttendance.setForeground(new Color(25, 25, 112));
		tableResultAttendance.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		tableResultAttendance.getTableHeader().setBackground(new Color(25, 25, 112));
		tableResultAttendance.getTableHeader().setForeground(Color.WHITE);
		tableResultAttendance.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sinh viên", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15"
			}
		));
		tableResultAttendance.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableResultAttendance.getColumnModel().getColumn(0).setPreferredWidth(400);
		tableResultAttendance.setRowHeight(25);
		tableResultAttendanceModel = (DefaultTableModel) tableResultAttendance.getModel();
		scrollPane.setViewportView(tableResultAttendance);
		
		JLabel lblNote = new JLabel("X: Tham dự         O: Vắng mặt");
		lblNote.setForeground(new Color(25, 25, 112));
		lblNote.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNote.setBounds(10, 39, 338, 49);
		add(lblNote);
		
		btnUpdate = new JButton("Cập nhật");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBackground(new Color(25, 25, 112));
		btnUpdate.setBounds(806, 49, 154, 39);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handeBtnUpdateClick();
			}

		});
		add(btnUpdate);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(403, 451, 154, 39);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToCourse();
			}

		});
		add(btnBack);
		
	}
	
	public void setTitle() {
		lblTitle.setText("Kết quả điểm danh khoá học " + course.getCourseName());
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void backToCourse() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showCourse(course);
	}
	
	public void displayResultAttendance() {
		List<Student> students = StudentDAO.getStudentsInCourse(course.getCourseId());
		tableResultAttendanceModel.setRowCount(0);
		for (Student student : students) {
			List<Attendance> attendanceList = AttendanceDAO.getAttendanceListOfStudentCourse(new StudentCourseId(student.getStudentId(), course.getCourseId()));
			addAttendanceToTable(student, attendanceList);
		}
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < tableResultAttendanceModel.getColumnCount(); columnIndex++) {
            tableResultAttendance.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
	}
	
	public void addAttendanceToTable(Student student, List<Attendance> attendanceList) {
		Object[] row = new Object[16];
		row[0] = student.toString();

		for (int i = 0; i < attendanceList.size(); i++) {
			if (attendanceList.get(i).getPresent() == null) {
				row[i + 1] = null;
			}
			else if (attendanceList.get(i).getPresent()) {
				row[i + 1] = "X";
			}
			else {
				row[i + 1] = "O";
			}
		}
		
		tableResultAttendanceModel.addRow(row);
	}
	
	public void handeBtnUpdateClick() {
		int column = tableResultAttendanceModel.getColumnCount();
		int row = tableResultAttendanceModel.getRowCount();
		for (int i = 0; i < row; i++) {
			String studentId = (tableResultAttendance.getValueAt(i, 0) + "").split("-")[0];
			for (int week = 1; week < column; week++) {
				Boolean present = null;
				String presentString = tableResultAttendance.getValueAt(i, week) + "";
				if (presentString.equals("X") || presentString.equals("x")) {
					present = true;
				}
				else if (presentString.equals("O") || presentString.equals("o")) {
					present = false;
				}
				
				AttendanceDAO.changePresent(studentId, course.getCourseId(), week, present);
			}
		}
		
		JOptionPane.showMessageDialog(this, "Cập nhật thành công");
		displayResultAttendance();
	}
	
}
