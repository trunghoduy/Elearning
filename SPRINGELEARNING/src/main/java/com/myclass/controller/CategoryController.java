package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;

@Controller
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@GetMapping()
	public Object get() {
		try {
			
		List<CategoryDto> dtos = categoryService.findAll();
		return new ResponseEntity<Object>(dtos,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);

	}
	
}
