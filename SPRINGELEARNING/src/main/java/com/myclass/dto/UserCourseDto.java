package com.myclass.dto;

public class UserCourseDto {

	private int user_id;
	private int course_id;
	
	public UserCourseDto() {
		
	}

	public UserCourseDto(int user_id, int course_id) {
		super();
		this.user_id = user_id;
		this.course_id = course_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}
