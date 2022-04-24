package com.thidinhxm.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	@GeneratedValue
	@Id
	private String subjectId;
	@Column(name="subjectName", nullable=false)
	private String subjectName;
	@Column(name="credits", nullable=false)
	private Integer credits;
	
	@OneToMany(mappedBy="subject", cascade=CascadeType.ALL)
	private Set<Course> courses;
	
	public Subject() {
	}
	
	public Subject(String subjectId, String subjectName, Integer credits) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.credits = credits;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
}
