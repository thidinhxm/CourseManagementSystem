package com.thidinhxm.entities;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance {
	@EmbeddedId
	private AttendanceId attendanceId;
	private Boolean present;
	private LocalDate dateLearn;
	
	@ManyToOne
	@MapsId("studentCourseId")
	@JoinColumns({
		@JoinColumn(name="studentId", referencedColumnName="studentId"),
		@JoinColumn(name="courseId", referencedColumnName="courseId")
	})
	StudentCourse studentCourse;
	
	public Attendance() {
	}
	public Attendance(AttendanceId attendanceId, Boolean present, LocalDate dateLearn, StudentCourse studentCourse) {
		this.attendanceId = attendanceId;
		this.present = present;
		this.dateLearn = dateLearn;
		this.studentCourse = studentCourse;
	}
	
	public Attendance(AttendanceId attendanceId, StudentCourse studentCourse) {
		this.attendanceId = attendanceId;
		this.studentCourse = studentCourse;
	}

	public AttendanceId getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(AttendanceId attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}
	
	public LocalDate getDateLearn() {
		return dateLearn;
	}

	public void setDateLearn(LocalDate dateLearn) {
		this.dateLearn = dateLearn;
	}

	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}
	
}
