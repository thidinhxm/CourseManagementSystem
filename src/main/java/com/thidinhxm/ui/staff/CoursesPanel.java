package com.thidinhxm.ui.staff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.thidinhxm.daos.CourseDAO;
import com.thidinhxm.daos.StudentCourseDAO;
import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.StudentCourse;
import com.thidinhxm.ui.student.StudentScreen;
import com.thidinhxm.utils.DateTimeUtil;

public class CoursesPanel extends JPanel {
	private JTable tableCourse;
	private JTextField txtCourse;
	private JTextField inputCourse;
	private JButton btnSearch;
	private DefaultTableModel tableCourseModel;
	private JButton btnAddCourse;
	
	public CoursesPanel(List<Course> courses) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Các khóa học");
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
			},
			new String[] {
				"Mã", "Tên khóa", "Bắt đầu", "Kết thúc", "Ngày học", "Từ", "Đến", "Phòng"
			}
		));
		tableCourse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCourse.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableCourse.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableCourse.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableCourse.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableCourse.getColumnModel().getColumn(4).setPreferredWidth(50);
		tableCourse.getColumnModel().getColumn(5).setPreferredWidth(30);
		tableCourse.getColumnModel().getColumn(6).setPreferredWidth(30);
		tableCourse.getColumnModel().getColumn(7).setPreferredWidth(20);
		tableCourse.setFocusable(false);
		tableCourse.setRowSelectionAllowed(true);
		tableCourse.setRowHeight(25);
		scrollPane.setViewportView(tableCourse);
		tableCourseModel = (DefaultTableModel) tableCourse.getModel();
		displayCourses(courses);
		tableCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableCourse.getSelectedRow();
				if (row >= 0) {
					goToCourseDetails(row);
				}
			}
		});
		
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
		inputCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputCourse.setForeground(new Color(25, 25, 112));
		inputCourse.setColumns(10);
		inputCourse.setBounds(180, 48, 486, 39);
		inputCourse.setBorder(new LineBorder(new Color(25, 25, 112)));
		add(inputCourse);
		
		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(25, 25, 112));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBounds(684, 48, 115, 39);
		add(btnSearch);
		
		btnAddCourse = new JButton("Thêm khóa");
		btnAddCourse.setForeground(Color.WHITE);
		btnAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddCourse.setBackground(new Color(25, 25, 112));
		btnAddCourse.setBounds(820, 48, 115, 39);
		
		add(btnAddCourse);
	}
	
	private void displayCourses(List<Course> courses) {
		tableCourseModel.setRowCount(0);
		for (Course course : courses) {
			addCourseToTable(course);
		}
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < tableCourseModel.getColumnCount(); columnIndex++) {
            tableCourse.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
	}
	
	private void addCourseToTable(Course course) {
		tableCourseModel.addRow(new Object[] {
			course.getCourseId() + "",
			course.getCourseName(),
			DateTimeUtil.getLocalDateString(course.getDateStart()),
			DateTimeUtil.getLocalDateString(course.getDateEnd()),
			course.getDayInWeek(),
			course.getPeriodIdStart().getTimeStart() + "",
			course.getPeriodIdEnd().getTimeEnd() + "",
			course.getRoom().getRoomName()
		});
	}
	
	public void unselectRow() {
		tableCourse.getSelectionModel().clearSelection();
	}
	
	private void goToCourseDetails(int rowIndex) {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		Integer courseId = Integer.parseInt(tableCourseModel.getValueAt(rowIndex, 0) + "");
		screen.showCourse(CourseDAO.getCourseById(courseId));
	}
}
