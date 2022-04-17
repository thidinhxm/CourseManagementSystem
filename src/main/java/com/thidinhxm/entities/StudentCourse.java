package com.thidinhxm.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_course")
public class StudentCourse implements Serializable{
	
	@EmbeddedId
	private StudentCourseId studentCourseId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("studentId")
	@JoinColumn(name="studentId")
	private Student student;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("courseId")
	@JoinColumn(name="courseId")
	private Course course;
	
	@Column(name="point")
	private float point;
	
	@OneToMany(mappedBy="studentCourse", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Attendance> attendances = new HashSet<Attendance>();
	
	public StudentCourse(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

	public StudentCourseId getStudentCourseId() {
		return studentCourseId;
	}

	public void setStudentCourseId(StudentCourseId studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}
	
	public Set<Attendance> getAttendances() {
		return attendances;
	}
	
	public void setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
	}
	
}
