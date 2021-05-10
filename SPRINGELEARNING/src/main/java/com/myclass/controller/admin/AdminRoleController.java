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
import com.myclass.dto.RoleDto;

import com.myclass.service.RoleService;

@Controller
@RequestMapping("api/admin/role")
public class AdminRoleController {

	private RoleService roleService;
	
	public AdminRoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@GetMapping("")
	public Object get() {
		List<RoleDto> dtos = roleService.getAll();

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
	public Object post(@RequestBody RoleDto dto) {
		try {
			roleService.insert(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/{id}")
	public Object get(@PathVariable("id") int id) {
		List<RoleDto> dtos = roleService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			RoleDto dto = roleService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public Object put(@PathVariable("id") int id,@RequestBody RoleDto dto) {
		try {
			roleService.update(id,dto);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			roleService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
