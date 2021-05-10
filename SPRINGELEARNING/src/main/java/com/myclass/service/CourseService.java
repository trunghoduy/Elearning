package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDto;

public interface CourseService {

	List<CourseDto> getAll();
	CourseDto getById(int id );
	void insert(CourseDto dto);
	void update(int id, CourseDto dto);
	void delete(int id);
}
