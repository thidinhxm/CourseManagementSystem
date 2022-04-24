package com.thidinhxm.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class AttendanceId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentCourseId studentCourseId;
	LocalDate dateLearn;
	
	public AttendanceId() {
	}
	
	public AttendanceId(StudentCourseId studentCourseId, LocalDate dateLearn) {
		this.studentCourseId = studentCourseId;
		this.dateLearn = dateLearn;
	}

	public StudentCourseId getStudentCourseId() {
		return studentCourseId;
	}
	public void setStudentCourseId(StudentCourseId studentCourseId) {
		this.studentCourseId = studentCourseId;
	}
	public LocalDate getDateLearn() {
		return dateLearn;
	}
	public void setDateLearn(LocalDate dateLearn) {
		this.dateLearn = dateLearn;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateLearn == null) ? 0 : dateLearn.hashCode());
		result = prime * result + ((studentCourseId == null) ? 0 : studentCourseId.hashCode());
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
		if (dateLearn == null) {
			if (other.dateLearn != null)
				return false;
		} else if (!dateLearn.equals(other.dateLearn))
			return false;
		if (studentCourseId == null) {
			if (other.studentCourseId != null)
				return false;
		} else if (!studentCourseId.equals(other.studentCourseId))
			return false;
		return true;
	}
	
	
}
