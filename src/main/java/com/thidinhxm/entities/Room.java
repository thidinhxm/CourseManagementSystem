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
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue
	private Integer roomId;
	
	@Column(name="roomName", length=255, nullable=false)
	private String roomName;
	
	@Column(name="usability", columnDefinition="default true")
	private Boolean usability;
	
	@OneToMany(mappedBy="room", cascade=CascadeType.ALL)
	private Set<Course> courses;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Boolean getUsability() {
		return usability;
	}

	public void setUsability(Boolean usability) {
		this.usability = usability;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public String toString() {
		return roomName;
	}
	
}
