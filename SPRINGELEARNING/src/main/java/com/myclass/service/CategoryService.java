package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;

public interface CategoryService {

	
	void insert(CategoryDto dto);

	List<CategoryDto> findAll();

	CategoryDto getById(int id);

	void update(int id, CategoryDto dto);

	CategoryDto delete(int id);

}
