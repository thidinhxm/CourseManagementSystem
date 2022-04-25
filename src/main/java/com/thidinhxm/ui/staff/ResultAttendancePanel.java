package com.thidinhxm.ui.staff;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class ResultAttendancePanel extends JPanel {
	private JTable table;


	public ResultAttendancePanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khoá học: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(222, 10, 532, 49);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 123, 838, 321);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setForeground(new Color(25, 25, 112));
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.PLAIN, 20 ));
		table.getTableHeader().setBackground(new Color(25, 25, 112));
		table.getTableHeader().setForeground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sinh viên", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15"
			}
		));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel lblDanhSchSinh = new JLabel("Kết quả điểm danh");
		lblDanhSchSinh.setForeground(new Color(25, 25, 112));
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSchSinh.setBounds(67, 57, 201, 49);
		add(lblDanhSchSinh);
		
	}

}
