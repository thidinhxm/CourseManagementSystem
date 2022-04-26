package com.thidinhxm.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	private String studentId;
	
	private String username;
	private String password;
	private String fullname;
	private LocalDate dateOfBirth;
	private String gender;
	private LocalDateTime lastChangePassword;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<StudentCourse> studentCourse = new HashSet<StudentCourse>();
	
	public Student() {
	}
	
	public Student(String studentId, String username, String password, String fullname, LocalDate dateOfBirth, String gender) {
		this.studentId = studentId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	public Student(String studentId, String fullname, LocalDate dateOfBirth, String gender) {
		this.studentId = studentId;
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
	public LocalDateTime getLastChangePassword() {
		return lastChangePassword;
	}
	public void setLastChangePassword(LocalDateTime lastChangePassword) {
		this.lastChangePassword = lastChangePassword;
	}
	
	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}
	
	public String toString() {
		return studentId + "-" + fullname;
	}
	
}
