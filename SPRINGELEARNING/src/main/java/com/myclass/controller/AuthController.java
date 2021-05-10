package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myclass.dto.LoginDto;
import com.myclass.dto.UserDto;
import com.myclass.service.AuthService;
import com.myclass.service.UserService;

@Controller
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		List<UserDto> dtos = userService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			UserDto dto = userService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PostMapping("resgiter")
	public Object post(@RequestBody UserDto userDto) {
		try {
			userService.insert(userDto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
}
