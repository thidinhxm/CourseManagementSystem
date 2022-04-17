package com.thidinhxm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course implements Serializable {
	@Id
	@GeneratedValue
	private Integer courseId;
	private String courseName;
	private Date dateStart;
	private Date dateEnd;
	
	@ManyToOne
	@JoinColumn(name="periodId", insertable=false, updatable=false)
	private Period periodStart;
	
	@ManyToOne
	@JoinColumn(name="periodId", insertable=false, updatable=false)
	private Period periodEnd;
	
	@ManyToOne
	@JoinColumn(name="roomId")
	private Room room;
	
	@ManyToOne
	@JoinColumn(name="subjectId")
	private Subject subject;
	
	@OneToMany(mappedBy="course", cascade= CascadeType.ALL, orphanRemoval=true)
	private Set<StudentCourse> studentCourse = new HashSet<StudentCourse>();

	public Course(String courseName, Date dateStart, Date dateEnd, Period periodStart, Period periodEnd, Room room,
			Subject subject) {
		super();
		this.courseName = courseName;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
		this.room = room;
		this.subject = subject;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Period getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Period periodStart) {
		this.periodStart = periodStart;
	}

	public Period getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Period periodEnd) {
		this.periodEnd = periodEnd;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}
	
	
}
