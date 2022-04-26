package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.thidinhxm.daos.AttendanceDAO;
import com.thidinhxm.daos.StudentCourseDAO;
import com.thidinhxm.daos.StudentDAO;
import com.thidinhxm.entities.Attendance;
import com.thidinhxm.entities.AttendanceId;
import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.Student;
import com.thidinhxm.entities.StudentCourse;
import com.thidinhxm.utils.DateTimeUtil;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class ChooseStudentPanel extends JPanel {
	private JTable tableStudent;
	private JTextField txtStudent;
	private JTextField inputStudent;
	private DefaultTableModel tableStudentModel;
	
	private Course course;
	private JLabel lblTitle;
	private JButton btnBack;
	public ChooseStudentPanel() {
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		lblTitle = new JLabel("Chọn sinh viên vào khóa");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(17, 0, 723, 49);
		add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 117, 723, 289);
		add(scrollPane);
		
		tableStudent = new JTable();
		tableStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableStudent.setForeground(new Color(25, 25, 112));
		tableStudent.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		tableStudent.getTableHeader().setBackground(new Color(25, 25, 112));
		tableStudent.getTableHeader().setForeground(Color.WHITE);
		tableStudent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MSSV", "Họ và tên", "Ngày sinh", "Giới tính"
			}
		));
		tableStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableStudent.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableStudent.getColumnModel().getColumn(1).setPreferredWidth(70);
		tableStudent.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableStudent.getColumnModel().getColumn(3).setPreferredWidth(70);
		tableStudent.setRowHeight(25);
		scrollPane.setViewportView(tableStudent);
		tableStudent.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tableStudentModel = (DefaultTableModel) tableStudent.getModel();
		
		JButton btnAdd = new JButton("Thêm sinh viên");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(195, 431, 154, 39);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				handleBtnAddClick();
				
			}
			
		});
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
		inputStudent.setBounds(162, 57, 444, 39);
		add(inputStudent);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(new Color(25, 25, 112));
		btnSearch.setBounds(625, 57, 115, 39);
		add(btnSearch);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(399, 431, 154, 39);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				backToCourse();	
			}
			
		});
		add(btnBack);

	}
	
	public void displayStudentsNotInCourse() {
		List<Student> studentsNotInCourse = StudentDAO.getStudentsNotInCourse(course.getCourseId());
		tableStudentModel.setRowCount(0);
		for (Student student : studentsNotInCourse) {
			tableStudentModel.addRow(new Object[] {
				tableStudent.getRowCount() + 1 + "",
				student.getStudentId(),
				student.getFullname(),
				DateTimeUtil.getLocalDateString(student.getDateOfBirth()),
				student.getGender(),
			});
		}
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < tableStudentModel.getColumnCount(); columnIndex++) {
        	tableStudent.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
	}
	
	public void setCourse(Course course) {
		this.course = course;
		displayStudentsNotInCourse();
	}
	
	public void setTitle() {
		lblTitle.setText("Chọn sinh viên vào khóa " + course.getCourseName());;
	}
	
	private void handleBtnAddClick() {
		
		
		int[] selectedRows = tableStudent.getSelectedRows();
		if (selectedRows.length > 0) {
			int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm sinh viên vào khóa học này?");
			if (choice == JOptionPane.YES_OPTION) {
				for (int row : selectedRows) {
					String studentId = tableStudent.getValueAt(row, 1) + "";
					Student student = StudentDAO.getStudentById(studentId);
					StudentCourse studentCourse = new StudentCourse(student, course);
					StudentCourseDAO.addStudentToCourse(studentCourse);
					for (int i = 1; i <= 15; i++) {
						AttendanceId attendanceId = new AttendanceId(studentCourse.getStudentCourseId(), i);
						Attendance attendance = new Attendance(attendanceId, studentCourse);
						AttendanceDAO.addAttendance(attendance);
						
					}
				}
				JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
				displayStudentsNotInCourse();
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên");
		}
	}
	
	private void backToCourse() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showCourse(course);
	}
}
