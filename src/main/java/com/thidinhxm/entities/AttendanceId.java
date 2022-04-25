package com.thidinhxm.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class AttendanceId implements Serializable{

	private static final long serialVersionUID = 1L;
	private StudentCourseId studentCourseId;
	private Integer weekLearn;
	
	public AttendanceId() {
	}

	public AttendanceId(StudentCourseId studentCourseId, Integer weekLearn) {
		super();
		this.studentCourseId = studentCourseId;
		this.weekLearn = weekLearn;
	}

	public StudentCourseId getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(StudentCourseId studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public Integer getWeekLearn() {
		return weekLearn;
	}

	public void setWeekLearn(Integer weekLearn) {
		this.weekLearn = weekLearn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentCourseId == null) ? 0 : studentCourseId.hashCode());
		result = prime * result + ((weekLearn == null) ? 0 : weekLearn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendanceId other = (AttendanceId) obj;
		if (studentCourseId == null) {
			if (other.studentCourseId != null)
				return false;
		} else if (!studentCourseId.equals(other.studentCourseId))
			return false;
		if (weekLearn == null) {
			if (other.weekLearn != null)
				return false;
		} else if (!weekLearn.equals(other.weekLearn))
			return false;
		return true;
	}
	
	
	
}
