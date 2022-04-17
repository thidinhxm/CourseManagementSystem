package com.thidinhxm.entities;

import java.sql.Time;
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
	private Integer periodId;
	
	@Column(name="timeStart", nullable=false)
	private Time timeStart;
	
	@Column(name="timeEnd", nullable=false)
	private Time timeEnd;
	
	@OneToMany(mappedBy="periodStart", cascade=CascadeType.ALL)
	private Set<Course> coursesStart = new HashSet<Course>();
	
	@OneToMany(mappedBy="periodEnd", cascade=CascadeType.ALL)
	private Set<Course> coursesEnd = new HashSet<Course>();

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId = periodId;
	}

	public Time getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Time timeStart) {
		this.timeStart = timeStart;
	}

	public Time getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Time timeEnd) {
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
