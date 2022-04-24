package com.thidinhxm.ui.student;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttendancePanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AttendancePanel() {
		setLayout(null);
		
		JLabel lblimDanh = new JLabel("\u0110i\u1EC3m danh kh\u00F3a h\u1ECDc");
		lblimDanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblimDanh.setForeground(new Color(25, 25, 112));
		lblimDanh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblimDanh.setBounds(341, 0, 236, 39);
		add(lblimDanh);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(75, 71, 810, 410);
		add(panel);
		
		JLabel lblBnCn = new JLabel("B\u1EA1n c\u00F2n ");
		lblBnCn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBnCn.setForeground(new Color(112, 128, 144));
		lblBnCn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBnCn.setBounds(199, 277, 114, 39);
		panel.add(lblBnCn);
		
		textField = new JTextField();
		textField.setText("01:00:00");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(new Color(25, 25, 112));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(25, 25, 112)));
		textField.setBackground(Color.WHITE);
		textField.setBounds(312, 277, 125, 39);
		panel.add(textField);
		
		JLabel lblimDanh_1 = new JLabel("\u0111\u1EC3 \u0111i\u1EC3m danh");
		lblimDanh_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblimDanh_1.setForeground(new Color(112, 128, 144));
		lblimDanh_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblimDanh_1.setBounds(436, 277, 147, 39);
		panel.add(lblimDanh_1);
		
		JButton btnimDanh = new JButton("\u0110i\u1EC3m danh");
		btnimDanh.setForeground(Color.WHITE);
		btnimDanh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnimDanh.setBackground(new Color(25, 25, 112));
		btnimDanh.setBounds(312, 343, 125, 39);
		panel.add(btnimDanh);
		
		JLabel lblDateLearn = new JLabel("Ngày học: ");
		lblDateLearn.setBounds(179, 199, 400, 47);
		panel.add(lblDateLearn);
		lblDateLearn.setForeground(new Color(112, 128, 144));
		lblDateLearn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lbln = new JLabel("\u0110\u1EBFn ");
		lbln.setBounds(179, 132, 400, 47);
		panel.add(lbln);
		lbln.setForeground(new Color(112, 128, 144));
		lbln.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTimeStart = new JLabel("Từ: ");
		lblTimeStart.setBounds(179, 75, 400, 47);
		panel.add(lblTimeStart);
		lblTimeStart.setForeground(new Color(112, 128, 144));
		lblTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTnKhaHc = new JLabel("T\u00EAn kh\u00F3a h\u1ECDc");
		lblTnKhaHc.setBounds(179, 10, 400, 47);
		panel.add(lblTnKhaHc);
		lblTnKhaHc.setForeground(new Color(112, 128, 144));
		lblTnKhaHc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
	}
}
