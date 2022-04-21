package com.thidinhxm.ui.staff;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImportStudentPanel extends JPanel {
	private JButton btnImport;
	private JButton btnAdd;
	private JScrollPane scrollPane;
	private JTable tableStudent;
	/**
	 * Create the panel.
	 */
	public ImportStudentPanel() {
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Th\u00EAm sinh vi\u00EAn t\u1EEB file");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(224, 0, 325, 49);
		add(lblTitle);
		
		JButton btnDownload = new JButton("T\u1EA3i template");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDownload.setForeground(Color.WHITE);
		btnDownload.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDownload.setBackground(new Color(25, 25, 112));
		btnDownload.setBounds(172, 46, 184, 39);
		add(btnDownload);
		
		btnImport = new JButton("Import t\u1EEB file");
		btnImport.setForeground(Color.WHITE);
		btnImport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnImport.setBackground(new Color(25, 25, 112));
		btnImport.setBounds(387, 46, 184, 39);
		add(btnImport);
		
		btnAdd = new JButton("Th\u00EAm sinh vi\u00EAn");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(25, 25, 112));
		btnAdd.setBounds(285, 421, 154, 39);
		add(btnAdd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 108, 733, 289);
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
		scrollPane.setViewportView(tableStudent);
	}

}
