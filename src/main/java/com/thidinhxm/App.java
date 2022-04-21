package com.thidinhxm;

import com.thidinhxm.daos.StudentDAO;
import com.thidinhxm.entities.Student;
import com.thidinhxm.utils.PasswordUtil;

public class App {
	public static void main(String[] args) {
		String password = "toi1";
		String hashedPassword = PasswordUtil.getSHA1SecurePassword(password);
		System.out.println(hashedPassword);
		
	}
}
