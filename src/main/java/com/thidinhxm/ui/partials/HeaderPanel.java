package com.thidinhxm.ui.partials;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class HeaderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HeaderPanel(String username) {
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(20, 30, 1145, 50);
		setLayout(null);
		
		JLabel lblHello = new JLabel("Xin chào " + username + ",");
		lblHello.setFont(new Font("Dialog", Font.BOLD, 16));
		lblHello.setForeground(new Color(25, 25, 112));
		lblHello.setBounds(10, 10, 210, 30);
		add(lblHello);
	}

}
