package com.thidinhxm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable{
	@Id
	private String studentId;
	
	private String username;
	private String password;
	private String fullname;
	private Date dateOfBirth;
	private String gender;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<StudentCourse> studentCourse = new HashSet<StudentCourse>();
	
	public Student(String studentId, String username, String password, String fullname, Date dateOfBirth, String gender) {
		this.studentId = studentId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public void addCourse(StudentCourse course) {
		studentCourse.add(course);
	}
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
	
	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}
	
}
