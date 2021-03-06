package com.thidinhxm.ui.staff;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

public class ImportStudentPanel extends JPanel {
	private JButton btnImport;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JTable tableStudent;
	private DefaultTableModel tableStudentModel;
	
	private Course course;
	private JLabel lblTitle;
	private JButton btnDownload;
	private JButton btnBack;
	
	public ImportStudentPanel() {
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		lblTitle = new JLabel("Thêm sinh viên từ file");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(17, 0, 723, 49);
		add(lblTitle);
		
		btnDownload = new JButton("Tải template");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				downloadTemplate();
			}
		});
		btnDownload.setForeground(Color.WHITE);
		btnDownload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDownload.setBackground(new Color(25, 25, 112));
		btnDownload.setBounds(172, 46, 184, 39);
		add(btnDownload);
		
		btnImport = new JButton("Import từ file");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importFromTemplate();
			}
		});
		btnImport.setForeground(Color.WHITE);
		btnImport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnImport.setBackground(new Color(25, 25, 112));
		btnImport.setBounds(387, 46, 184, 39);
		add(btnImport);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 108, 723, 289);
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
				"MSSV", "Họ và tên", "Ngày sinh (yyyy-mm-dd)", "Giới tính"
			}
		));
		tableStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableStudent.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableStudent.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableStudent.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableStudent.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableStudent.setRowHeight(25);
		tableStudentModel = (DefaultTableModel) tableStudent.getModel();
		scrollPane.setViewportView(tableStudent);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(404, 421, 154, 39);
		add(btnBack);
		btnBack.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				backToCourse();	
			}
			
		});
		
		btnAdd = new JButton("Thêm sinh viên");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(200, 422, 154, 39);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				handleBtnAddClick();	
			}
			
		});
		add(btnAdd);
		
	}
	
	private void downloadTemplate() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(".csv", "csv"));
		fileChooser.setSelectedFile(new File("template.csv"));
		int returnVal = fileChooser.showSaveDialog(this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			writeTemplate(file.getAbsolutePath());
		}
	}
	
	private void writeTemplate(String path) {
		try {
			FileOutputStream file = new FileOutputStream(path);
			OutputStreamWriter writer = new OutputStreamWriter(file, StandardCharsets.UTF_8);
			writer.write("MSSV, Ho va ten, Ngay sinh (yyyy-mm-dd), Gioi tinh");
			writer.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void importFromTemplate() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter(".csv", "csv"));
		
		int returnVal = fileChooser.showSaveDialog(this);
				
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			List<Student> students = readTemplate(file);
			reloadData(students);
		}	
	}
	
	private List<Student> readTemplate(File file) {
		List<Student> students = new ArrayList<Student>();
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			FileInputStream fis = new FileInputStream(file);
		    InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
		    BufferedReader reader = new BufferedReader(isr);
		    
		    String str = reader.readLine();
		    while ((str = reader.readLine()) != null) {
		    	String[] strList = str.split(",");
		    	students.add(new Student(strList[0], strList[1], LocalDate.parse(strList[2], formatter), strList[3]));
		    }
			reader.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (EOFException e) {
			System.out.println(e.getMessage());
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		return students;
	}
	
	private void reloadData(List<Student> students) {
		tableStudentModel.setRowCount(0);
		for (Student student : students) {
			tableStudentModel.addRow(new Object[] {
					student.getStudentId(),
					student.getFullname(),
					DateTimeUtil.getLocalDateString(student.getDateOfBirth()),
					student.getGender()
			});
		}
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setTitle() {
		lblTitle.setText("Thêm sinh viên từ file vào khóa " + course.getCourseName());;
	}
	
	private void backToCourse() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showCourse(course);
	}
	
	private void handleBtnAddClick() {
		int rowCount = tableStudent.getRowCount();
		if (rowCount > 0) {
			int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm sinh viên vào khóa học này?");
			if (choice == JOptionPane.YES_OPTION) {
				for (int row = 0; row < rowCount; row++) {
					String studentId = tableStudent.getValueAt(row, 0) + "";
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
				tableStudentModel.setRowCount(0);
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "Vui lòng import file");
		}
		
	}
}
