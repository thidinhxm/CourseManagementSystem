package com.thidinhxm.entities;

import java.time.LocalTime;
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
@Table(name="period")
public class Period {
	@Id
	@GeneratedValue
	@Column(name="periodId")
	private Integer periodId;
	
	@Column(name="periodStart", nullable=false)
	private LocalTime timeStart;
	
	@Column(name="periodEnd", nullable=false)
	private LocalTime timeEnd;
	
	@OneToMany(mappedBy="periodIdStart", cascade=CascadeType.ALL)
	private Set<Course> coursesStart = new HashSet<Course>();
	
	@OneToMany(mappedBy="periodIdEnd", cascade=CascadeType.ALL)
	private Set<Course> coursesEnd = new HashSet<Course>();

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	public LocalTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(LocalTime timeStart) {
		this.timeStart = timeStart;
	}

	public LocalTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Set<Course> getCoursesStart() {
		return coursesStart;
	}

	public void setCoursesStart(Set<Course> coursesStart) {
		this.coursesStart = coursesStart;
	}

	public Set<Course> getCoursesEnd() {
		return coursesEnd;
	}

	public void setCoursesEnd(Set<Course> coursesEnd) {
		this.coursesEnd = coursesEnd;
	}
}
