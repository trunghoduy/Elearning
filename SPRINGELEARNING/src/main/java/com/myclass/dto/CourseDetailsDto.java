package com.myclass.dto;

import java.util.List;

public class CourseDetailsDto {

	private CourseDto course;
	private List<VideoDto> video;
	public CourseDetailsDto(CourseDto course, List<VideoDto> video) {
		super();
		this.course = course;
		this.video = video;
	}
	public CourseDto getCourse() {
		return course;
	}
	public void setCourse(CourseDto course) {
		this.course = course;
	}
	public List<VideoDto> getVideo() {
		return video;
	}
	public void setVideo(List<VideoDto> video) {
		this.video = video;
	}
	
}
