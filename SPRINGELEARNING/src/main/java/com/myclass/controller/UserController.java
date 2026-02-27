package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.dto.PasswordDto;
import com.myclass.dto.UserCourseDto;
import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.service.UserService;

@Controller
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserService userService;
	@GetMapping("profile")
	public Object get() {
		try {
			UserDto userDto = userService.getProfile();
			return new ResponseEntity<Object>(userDto,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	
	}
	@PostMapping("")
	public Object post(@RequestBody  UserDto dto) {	
		try {
			userService.insert(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@CrossOrigin(origins = "*")
	@PutMapping("/edit/{id}")
	public Object put(@RequestBody PasswordDto passwordDto ,@PathVariable int id) {
		try {
			String message = userService.changePassword(passwordDto, id);
			if(message !=null)
			return new ResponseEntity<Object>(message,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("course")
	public Object post(@RequestBody UserCourseDto userCourseDto) {
		
		try {
			 userService.saveCourse(userCourseDto);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		
	}
}
