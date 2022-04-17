package com.thidinhxm.entities;

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
	
	@ManyToOne
	@MapsId("studentCourseId")
	@JoinColumns({
		@JoinColumn(name="studentId", referencedColumnName="studentId"),
		@JoinColumn(name="courseId", referencedColumnName="courseId")
	})
	StudentCourse studentCourse;
	
}
