package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.thidinhxm.daos.SubjectDAO;
import com.thidinhxm.entities.Subject;

public class SubjectsPanel extends JPanel {
	private JTextField txtSubject;
	private JTextField inputSubject;
	private JTable tableSubject;
	private DefaultTableModel tableSubjectModel;
	private JButton btnAdd;
	private JButton btnSearch;

	public SubjectsPanel() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Các môn học");
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(369, 10, 236, 39);
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
		txtSubject.setBounds(34, 53, 125, 39);
		add(txtSubject);
		
		inputSubject = new JTextField();
		inputSubject.setForeground(new Color(25, 25, 112));
		inputSubject.setColumns(10);
		inputSubject.setBorder(new LineBorder(new Color(25, 25, 112)));
		inputSubject.setBounds(179, 53, 430, 39);
		add(inputSubject);
		
		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setBackground(new Color(25, 25, 112));
		btnSearch.setBounds(635, 53, 115, 39);
		add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 106, 900, 375);
		add(scrollPane);
		
		tableSubject = new JTable();
		tableSubject.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableSubject.setForeground(new Color(25, 25, 112));
		tableSubject.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		tableSubject.getTableHeader().setBackground(new Color(25, 25, 112));
		tableSubject.getTableHeader().setForeground(Color.WHITE);
		tableSubject.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Mã môn học", "Tên môn học", "Số tín chỉ"
			}
		));
		
		tableSubject.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableSubject.getColumnModel().getColumn(1).setPreferredWidth(100);
		tableSubject.getColumnModel().getColumn(2).setPreferredWidth(500);
		tableSubject.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableSubject.setRowHeight(25);
		tableSubjectModel = (DefaultTableModel) tableSubject.getModel();
		displayTable(SubjectDAO.getSubjects());
		scrollPane.setViewportView(tableSubject);
		
		btnAdd = new JButton("Thêm môn học");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(783, 53, 151, 39);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToAddSubject();
			}
		});
		add(btnAdd);

	}
	
	public void goToAddSubject() {
		StaffScreen screen = (StaffScreen) SwingUtilities.windowForComponent(this);
		screen.showAddSubject();
	}
	
	private void addSubjectToTable(Subject subject) {
		tableSubjectModel.addRow(new Object[] {
			tableSubject.getRowCount() + 1 + "",
			subject.getSubjectId(),
			subject.getSubjectName(),
			subject.getCredits() + ""
		});
	}
	
	public void displayTable(List<Subject> subjects) {
		tableSubjectModel.setRowCount(0);
		for (Subject subject : subjects) {
			addSubjectToTable(subject);
		}
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int columnIndex = 0; columnIndex < tableSubjectModel.getColumnCount(); columnIndex++) {
        	tableSubject.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
	}
}
