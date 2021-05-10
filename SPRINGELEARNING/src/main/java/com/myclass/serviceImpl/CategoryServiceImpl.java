package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository =categoryRepository;
	}
	
	@Override
	public List<CategoryDto> findAll() {
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();
		try {
			List<Category> entities = categoryRepository.findAll();
			for (Category entity : entities) {
				CategoryDto dto = new CategoryDto(
						entity.getId(), entity.getIcon(), entity.getTitle());
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	@Override
	public void insert(CategoryDto dto) {
		Category entity = new Category(dto.getId(),dto.getIcon(),dto.getTitle());
		categoryRepository.save(entity);
		
	}

	

	@Override
	public CategoryDto getById(int id) {
	Category entity =  categoryRepository.findById(id).get();
		
		return new CategoryDto(entity.getId(), entity.getIcon(), entity.getTitle());
	}

	@Override
	public void update(int id, CategoryDto dto) {
		if(categoryRepository.existsById(id)) {
			Category entity = new Category(dto.getId(),dto.getIcon(),dto.getTitle());
			entity.setIcon(dto.getIcon());
			entity.setTitle(dto.getTitle());
			categoryRepository.save(entity);
		}	
		
	}

	@Override
	public CategoryDto delete(int id) {
		if(categoryRepository.existsById(id)) {
	//		Category entity = categoryRepository.getOne(id);
	//		categoryRepository.delete(entity);
		}	
		return null;
	}
}
