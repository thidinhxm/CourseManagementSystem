package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.thidinhxm.daos.CourseDAO;
import com.thidinhxm.daos.PeriodDAO;
import com.thidinhxm.daos.RoomDAO;
import com.thidinhxm.daos.SubjectDAO;
import com.thidinhxm.entities.Course;
import com.thidinhxm.entities.Period;
import com.thidinhxm.entities.Room;
import com.thidinhxm.entities.Subject;
import com.thidinhxm.utils.DateLabelFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.SpringLayout;

public class AddCoursePanel extends JPanel {
	private JTextField txtSubject;
	private JTextField txtDateStart;
	private JTextField txtDateLearn;
	private JTextField txtDateEnd;
	private JTextField txtRoom;
	private JTextField txtTimeStart;
	private JTextField txtTimeEnd;
	private JTextField txtCourseName;
	private JTextField inputCourseName;
	private JComboBox<Subject> comboBoxSubject;
	private JComboBox<Period> comboBoxTimeStart;
	private JComboBox<Period> comboBoxTimeEnd;
	private JComboBox<Room> comboBoxRoom;
	private JComboBox<String> comboBoxDateLearn;
	private JButton btnAdd;
	private JButton btnBack;
	private JDatePanelImpl datePanel;
	private Properties p;
	private UtilDateModel model;
	private SpringLayout springLayoutDateStart;
	private JDatePickerImpl datePickerDateStart;
	private JDatePickerImpl datePickerDateEnd;
	private SpringLayout springLayoutDateEnd;
	private UtilDateModel modelDateStart;
	private JDatePanelImpl dateStartPanel;
	private UtilDateModel modelDateEnd;
	private JDatePanelImpl dateEndPanel;

	public AddCoursePanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Thêm khóa học");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(330, 10, 236, 39);
		add(lblTitle);
		
		txtSubject = new JTextField();
		txtSubject.setText("Môn học");
		txtSubject.setHorizontalAlignment(SwingConstants.CENTER);
		txtSubject.setForeground(new Color(25, 25, 112));
		txtSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSubject.setEditable(false);
		txtSubject.setColumns(10);
		txtSubject.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtSubject.setBackground(Color.WHITE);
		txtSubject.setBounds(96, 78, 125, 39);
		add(txtSubject);
		
		txtDateStart = new JTextField();
		txtDateStart.setText("Ngày bắt đầu");
		txtDateStart.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateStart.setForeground(new Color(25, 25, 112));
		txtDateStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateStart.setEditable(false);
		txtDateStart.setColumns(10);
		txtDateStart.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateStart.setBackground(Color.WHITE);
		txtDateStart.setBounds(96, 207, 125, 39);
		add(txtDateStart);
		
		txtDateLearn = new JTextField();
		txtDateLearn.setText("Ngày học");
		txtDateLearn.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateLearn.setForeground(new Color(25, 25, 112));
		txtDateLearn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateLearn.setEditable(false);
		txtDateLearn.setColumns(10);
		txtDateLearn.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateLearn.setBackground(Color.WHITE);
		txtDateLearn.setBounds(96, 270, 125, 39);
		add(txtDateLearn);
		
		txtDateEnd = new JTextField();
		txtDateEnd.setText("Ngày kết thúc");
		txtDateEnd.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateEnd.setForeground(new Color(25, 25, 112));
		txtDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateEnd.setEditable(false);
		txtDateEnd.setColumns(10);
		txtDateEnd.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtDateEnd.setBackground(Color.WHITE);
		txtDateEnd.setBounds(506, 207, 125, 39);
		add(txtDateEnd);
		
		txtRoom = new JTextField();
		txtRoom.setText("Phòng học");
		txtRoom.setHorizontalAlignment(SwingConstants.CENTER);
		txtRoom.setForeground(new Color(25, 25, 112));
		txtRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRoom.setEditable(false);
		txtRoom.setColumns(10);
		txtRoom.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtRoom.setBackground(Color.WHITE);
		txtRoom.setBounds(506, 270, 125, 39);
		add(txtRoom);
		
		txtTimeStart = new JTextField();
		txtTimeStart.setText("Từ");
		txtTimeStart.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeStart.setForeground(new Color(25, 25, 112));
		txtTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimeStart.setEditable(false);
		txtTimeStart.setColumns(10);
		txtTimeStart.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtTimeStart.setBackground(Color.WHITE);
		txtTimeStart.setBounds(96, 330, 125, 39);
		add(txtTimeStart);
		
		modelDateStart = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		dateStartPanel = new JDatePanelImpl(modelDateStart, p);
		datePickerDateStart = new JDatePickerImpl(dateStartPanel, new DateLabelFormatter());
		datePickerDateStart.setBackground(new Color(255, 255, 255));
		
		springLayoutDateStart = (SpringLayout) datePickerDateStart.getLayout();
		springLayoutDateStart.putConstraint(SpringLayout.NORTH, datePickerDateStart.getJFormattedTextField(), -25, SpringLayout.SOUTH, datePickerDateStart);
		springLayoutDateStart.putConstraint(SpringLayout.SOUTH, datePickerDateStart.getJFormattedTextField(), 12, SpringLayout.SOUTH, datePickerDateStart);
		datePickerDateStart.setSize(217, 39);
		datePickerDateStart.setLocation(241, 207);
		datePickerDateStart.getJFormattedTextField().setForeground(new Color(25, 25, 112));
		datePickerDateStart.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		datePickerDateStart.getJFormattedTextField().setBorder(new LineBorder(new Color(25, 25, 112)));
		datePickerDateStart.getJFormattedTextField().setBackground(Color.WHITE);
		add(datePickerDateStart);
		
		
		modelDateEnd = new UtilDateModel();
		dateEndPanel = new JDatePanelImpl(modelDateEnd, p);
		datePickerDateEnd = new JDatePickerImpl(dateEndPanel, new DateLabelFormatter());
		datePickerDateEnd.setBackground(new Color(255, 255, 255));
		
		springLayoutDateEnd = (SpringLayout) datePickerDateEnd.getLayout();
		springLayoutDateEnd.putConstraint(SpringLayout.NORTH, datePickerDateEnd.getJFormattedTextField(), -25, SpringLayout.SOUTH, datePickerDateStart);
		springLayoutDateEnd.putConstraint(SpringLayout.SOUTH, datePickerDateEnd.getJFormattedTextField(), 12, SpringLayout.SOUTH, datePickerDateStart);
		datePickerDateEnd.setSize(217, 39);
		datePickerDateEnd.setLocation(651, 207);
		datePickerDateEnd.getJFormattedTextField().setForeground(new Color(25, 25, 112));
		datePickerDateEnd.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		datePickerDateEnd.getJFormattedTextField().setBorder(new LineBorder(new Color(25, 25, 112)));
		datePickerDateEnd.getJFormattedTextField().setBackground(Color.WHITE);
		add(datePickerDateEnd);
		
		txtTimeEnd = new JTextField();
		txtTimeEnd.setText("Đến");
		txtTimeEnd.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeEnd.setForeground(new Color(25, 25, 112));
		txtTimeEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimeEnd.setEditable(false);
		txtTimeEnd.setColumns(10);
		txtTimeEnd.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtTimeEnd.setBackground(Color.WHITE);
		txtTimeEnd.setBounds(506, 330, 125, 39);
		add(txtTimeEnd);
		
		txtCourseName = new JTextField();
		txtCourseName.setText("Tên khóa học");
		txtCourseName.setHorizontalAlignment(SwingConstants.CENTER);
		txtCourseName.setForeground(new Color(25, 25, 112));
		txtCourseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCourseName.setEditable(false);
		txtCourseName.setColumns(10);
		txtCourseName.setBorder(new LineBorder(new Color(25, 25, 112)));
		txtCourseName.setBackground(Color.WHITE);
		txtCourseName.setBounds(96, 141, 125, 39);
		add(txtCourseName);
		
		inputCourseName = new JTextField();
		inputCourseName.setForeground(new Color(25, 25, 112));
		inputCourseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		inputCourseName.setColumns(10);
		inputCourseName.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputCourseName.setBounds(241, 141, 627, 39);
		add(inputCourseName);
		
		comboBoxSubject = new JComboBox<Subject>();
		comboBoxSubject.setForeground(new Color(25, 25, 112));
		comboBoxSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSubject.setBackground(Color.WHITE);
		comboBoxSubject.setBounds(241, 79, 627, 37);
		add(comboBoxSubject);
		
		List<Subject> subjects = SubjectDAO.getSubjects();
		for (Subject subject : subjects) {
			comboBoxSubject.addItem(subject);
		}
		
		comboBoxTimeStart = new JComboBox<Period>(new DefaultComboBoxModel<Period>());
		comboBoxTimeStart.setForeground(new Color(25, 25, 112));
		comboBoxTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxTimeStart.setBackground(Color.WHITE);
		comboBoxTimeStart.setBounds(241, 331, 217, 37);
		
		List<Period> periodList = PeriodDAO.getPeriodList();
		
		comboBoxTimeStart.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Period){
                	Period period = (Period) value;
                    StringBuilder sb = new StringBuilder();
                    sb.append(period.getTimeStart());
                    setText(sb.toString());
                }
                return this;
            }
		});
		
		for (Period period : periodList) {
			comboBoxTimeStart.addItem(period);
		}
		
		
		
		add(comboBoxTimeStart);
		
		comboBoxTimeEnd = new JComboBox<Period>();
		comboBoxTimeEnd.setForeground(new Color(25, 25, 112));
		comboBoxTimeEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxTimeEnd.setBackground(Color.WHITE);
		comboBoxTimeEnd.setBounds(651, 331, 217, 37);
		
		comboBoxTimeEnd.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof Period){
                	Period period = (Period) value;
                    StringBuilder sb = new StringBuilder();
                    sb.append(period.getTimeEnd());
                    setText(sb.toString());
                }
                return this;
            }
		});
		
		for (Period period : periodList) {
			comboBoxTimeEnd.addItem(period);
		}
		add(comboBoxTimeEnd);
		
		comboBoxRoom = new JComboBox<Room>();
		comboBoxRoom.setForeground(new Color(25, 25, 112));
		comboBoxRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxRoom.setBackground(Color.WHITE);
		comboBoxRoom.setBounds(651, 270, 217, 37);
		
		List<Room> rooms = RoomDAO.getRooms();
		for (Room room : rooms) {
			comboBoxRoom.addItem(room);
		}
		
		add(comboBoxRoom);
		
		comboBoxDateLearn = new JComboBox<String>();
		comboBoxDateLearn.setForeground(new Color(25, 25, 112));
		comboBoxDateLearn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxDateLearn.setBackground(Color.WHITE);
		comboBoxDateLearn.setBounds(241, 272, 217, 37);
		add(comboBoxDateLearn);
		
		String[] dateLearnInWeek = { "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy" };
		
		for (String date : dateLearnInWeek) {
			comboBoxDateLearn.addItem(date);
		}
		
		
		btnAdd = new JButton("Thêm khóa học");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(307, 412, 151, 39);
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				handleBtnAddClick();
			}
		});
		add(btnAdd);
		
		btnBack = new JButton("Quay lại");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(506, 412, 151, 39);
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				backToCourses();
			}
		});
		add(btnBack);

	}
	
	public void backToCourses() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showCourses();
	}
	
	public void handleBtnAddClick() {
		Subject subject = (Subject) comboBoxSubject.getSelectedItem();
		String courseName = inputCourseName.getText();
		String dateLearn = (String) comboBoxDateLearn.getSelectedItem();
		Period periodTimeStart = (Period) comboBoxTimeStart.getSelectedItem();
		Period periodTimeEnd = (Period) comboBoxTimeEnd.getSelectedItem();
		LocalDate dateStart = LocalDate.parse(datePickerDateStart.getJFormattedTextField().getText());
		LocalDate dateEnd = LocalDate.parse(datePickerDateEnd.getJFormattedTextField().getText());
		Room room = (Room) comboBoxRoom.getSelectedItem();
		
		
		Course course = new Course();
		course.setCourseName(courseName);
		course.setDateStart(dateStart);
		course.setDateEnd(dateEnd);
		course.setDayInWeek(dateLearn);
		course.setSubject(subject);
		course.setPeriodIdStart(periodTimeStart);
		course.setPeriodIdEnd(periodTimeEnd);
		course.setRoom(room);
		
		Boolean check = CourseDAO.addCourse(course);
		
		if (check) {
			JOptionPane.showMessageDialog(this, "Thêm khóa học thành công");
		}
		else {
			JOptionPane.showMessageDialog(this, "Thêm khóa học thất bại");
		}
	}
	
}
