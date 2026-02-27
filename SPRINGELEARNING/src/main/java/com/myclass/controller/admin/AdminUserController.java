package com.myclass.controller.admin;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myclass.dto.UserDto;

import com.myclass.service.RoleService;
import com.myclass.service.UserService;

@Controller
@RequestMapping("api/admin/user")
public class AdminUserController {
	

	private UserService userService;
	private RoleService roleService;
	public AdminUserController(UserService userService,RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
 
	@GetMapping("")
	public Object get() {
		
		List<UserDto> dtos = userService.getAll();		
	
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(dtos);
		return new ResponseEntity<Object>(json, HttpStatus.OK);
		} catch (JsonProcessingException e) {
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
	@GetMapping("edit/{id}")
	public Object get(@PathVariable int id) {
		try {
			UserDto dto = userService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("edit/{id}")
	public Object put(@PathVariable int id,@RequestBody UserDto dto) {
		try {
			userService.update(id,dto);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("delete/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			userService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
}
