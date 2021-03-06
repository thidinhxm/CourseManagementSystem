package com.thidinhxm.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {
	
	@Id
	private String staffId;

	private String username;
	private String password;
	private String fullname;
	private LocalDate dateOfBirth;
	private String gender;
	
	public Staff() {
	}
	
	public Staff(String staffId, String username, String password, String fullname, LocalDate dateOfBirth, String gender) {
		this.staffId = staffId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
