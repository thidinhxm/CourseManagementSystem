package com.thidinhxm;

import javax.swing.UIManager;

import com.thidinhxm.ui.partials.LoginScreen;

public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		new LoginScreen();
		
	}
}
