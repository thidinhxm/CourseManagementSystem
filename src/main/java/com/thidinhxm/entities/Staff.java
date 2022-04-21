package com.thidinhxm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="staff")
public class Staff implements Serializable {
	
	@Id
	private String staffId;
	
	@Column(name="username", length=255, nullable=false)
	private String username;
	
	@Column(name="password", length=255, nullable=false)
	private String password;
	
	@Column(name="fullname", length=255, nullable=false)
	private String fullname;
	
	@Column(name="dateOfBirth", nullable=false)
	private Date dateOfBirth;
	
	@Column(name="gender", length=255, nullable=false)
	private String gender;
	
	public Staff() {
	}
	
	public Staff(String staffId, String username, String password, String fullname, Date dateOfBirth, String gender) {
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
