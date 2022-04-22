package com.thidinhxm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String dayInWeek;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="periodIdStart", insertable=false, updatable=false)
	private Period periodIdStart;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="periodIdEnd", insertable=false, updatable=false)
	private Period periodIdEnd;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="roomId")
	private Room room;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="subjectId")
	private Subject subject;
	
	@OneToMany(mappedBy="course", cascade= CascadeType.ALL, orphanRemoval=true)
	private Set<StudentCourse> studentCourse = new HashSet<StudentCourse>();

	public Course() {
	}
	
	public Course(String courseName, Date dateStart, Date dateEnd, String dayInWeek, Period periodIdStart, Period periodIdEnd, Room room,
			Subject subject) {
		super();
		this.courseName = courseName;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.dayInWeek = dayInWeek;
		this.periodIdStart = periodIdStart;
		this.periodIdEnd = periodIdEnd;
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
	
	public String getDayInWeek() {
		return dayInWeek;
	}
	
	public void setDayInWeek(String dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

	public Period getPeriodIdStart() {
		return periodIdStart;
	}

	public void setPeriodIdStart(Period periodIdStart) {
		this.periodIdStart = periodIdStart;
	}

	public Period getPeriodIdEnd() {
		return periodIdEnd;
	}

	public void setPeriodIdEnd(Period periodIdEnd) {
		this.periodIdEnd = periodIdEnd;
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
