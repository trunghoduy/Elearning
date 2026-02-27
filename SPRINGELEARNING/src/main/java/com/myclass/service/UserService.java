package com.myclass.service;

import java.util.List;

import com.myclass.dto.PasswordDto;
import com.myclass.dto.UserCourseDto;
import com.myclass.dto.UserDto;

public interface UserService {

	List<UserDto> getAll();


	void insert(UserDto dto);

	UserDto getById(int id);

	void update(int id, UserDto dto);

	void delete (int id );
	
	UserDto getProfile();
	
	String changePassword(PasswordDto dto, int id);


	void saveCourse(UserCourseDto userCourseDto);
}
