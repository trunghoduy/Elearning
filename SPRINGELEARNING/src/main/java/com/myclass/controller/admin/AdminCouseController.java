package com.myclass.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.myclass.dto.CourseDto;
import com.myclass.dto.RoleDto;
import com.myclass.service.CourseService;

@Controller
@RequestMapping("api/admin/couse")
public class AdminCouseController {

	@Autowired
	private CourseService courseService;
	@GetMapping
	public Object get() {
		List<CourseDto> dtos = courseService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(dtos);
			return new ResponseEntity<Object>(json, HttpStatus.OK);

		} catch (JsonProcessingException  e) {
			e.printStackTrace();
			}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

	}
	@PostMapping("")
	public Object post(@RequestBody CourseDto dto) {
		try {
			courseService.insert(dto);
			return new ResponseEntity<Object>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/edit/{id}")
	public Object get(@PathVariable("id") int id) {
		List<CourseDto> dtos = courseService.getAll();
		ObjectMapper mapper = new ObjectMapper();
		try {
			CourseDto dto =courseService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	@PutMapping("/{id}")
	public Object put(@PathVariable("id") int id,@RequestBody CourseDto dto) {
		try {
			courseService.update(id,dto);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

	}
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			courseService.delete(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
		
}
