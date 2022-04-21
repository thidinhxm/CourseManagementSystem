package com.thidinhxm.ui.student;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CoursePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CoursePanel() {
		setBackground(new Color(248, 248, 255));
		setLayout(null);
		
		JLabel lblTitle = new JLabel("Khoá học: ");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(25, 25, 112));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(352, 10, 195, 49);
		add(lblTitle);
		
		JLabel lblDateStart = new JLabel("Ngày bắt đầu");
		lblDateStart.setForeground(new Color(112, 128, 144));
		lblDateStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateStart.setBounds(89, 96, 116, 22);
		add(lblDateStart);
		
		JLabel lblDateEnd = new JLabel("Ngày kết thúc");
		lblDateEnd.setForeground(new Color(112, 128, 144));
		lblDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateEnd.setBounds(637, 96, 116, 22);
		add(lblDateEnd);
		
		JLabel lblDateLearn = new JLabel("Ngày học");
		lblDateLearn.setForeground(new Color(112, 128, 144));
		lblDateLearn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateLearn.setBounds(89, 268, 116, 22);
		add(lblDateLearn);
		
		JLabel lblTimeStart = new JLabel("Từ");
		lblTimeStart.setForeground(new Color(112, 128, 144));
		lblTimeStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeStart.setBounds(89, 185, 174, 22);
		add(lblTimeStart);
		
		JLabel lblTimeEnd = new JLabel("Đến");
		lblTimeEnd.setForeground(new Color(112, 128, 144));
		lblTimeEnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTimeEnd.setBounds(637, 185, 174, 22);
		add(lblTimeEnd);
		
		JLabel lblRoom = new JLabel("Phòng học");
		lblRoom.setForeground(new Color(112, 128, 144));
		lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoom.setBounds(637, 268, 116, 22);
		add(lblRoom);
		
		JButton btnViewResult = new JButton("Xem k\u1EBFt qu\u1EA3 \u0111i\u1EC3m danh");
		btnViewResult.setForeground(new Color(255, 255, 255));
		btnViewResult.setBackground(new Color(25, 25, 112));
		btnViewResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewResult.setBounds(89, 386, 255, 36);
		add(btnViewResult);
		
		JButton btnBack = new JButton("Quay l\u1EA1i");
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(628, 386, 255, 36);
		add(btnBack);

	}
}
