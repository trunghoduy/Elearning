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
@Table(name="videos")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String title;
	private String url;
	@Column(name = "time_count" )
	private int timeCout;
	@Column(name = "course_id" )
	private int course_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="course_id", insertable=false, updatable=false)
	private Course course;

	public Video() {
		
	}
	public Video(int id, String title, String url, int timeCout, int course_id)  {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.timeCout = timeCout;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTimeCout() {
		return timeCout;
	}

	public void setTimeCout(int timeCout) {
		this.timeCout = timeCout;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	
}
