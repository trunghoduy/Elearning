package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tergets")
public class Target {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name= "title")
	private String title;
	@Column(name="course_id")
	private int course_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="course_id", insertable=false, updatable=false)
	private Course course;
	
	public Target() {
		
	}
	public Target(int id, String title, int course_id) {
		super();
		this.id = id;
		this.title = title;
		this.course_id = course_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
	
}
