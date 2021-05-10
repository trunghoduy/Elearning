package com.myclass.dto;

public class VideoDto {

	private int id ;
	private String title;
	private String url;
	private int timeCout;
	private int course_id;
	
	public VideoDto() {
		
	}
	
	public VideoDto(int id, String title, String url, int timeCout, int course_id) {
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
