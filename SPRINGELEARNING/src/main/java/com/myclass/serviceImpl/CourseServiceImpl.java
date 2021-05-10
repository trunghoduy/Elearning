package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Course;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Override
	public List<CourseDto> getAll() {
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		List<Course> entities = courseRepository.findAll();
		for (Course entity : entities) {
			CourseDto dto = new CourseDto();
			dto.setId(entity.getId());
			dto.setTitle(entity.getTitle());
			dto.setDescription(entity.getDescription());
			dto.setContent(entity.getContent());
			dto.setImage(entity.getImage());
			dto.setCate_id(entity.getCate_id());
			dto.setLetures_count(entity.getLetures_count());
			dto.setHour_count(entity.getHour_count());
			dto.setView_count(entity.getView_count());
			dto.setPrice(entity.getPrice());
			dto.setDiscout(entity.getDiscout());
			dto.setPromotion_price(entity.getPromotion_price());
			dto.setLast_update(entity.getLast_update());
			dtos.add(dto);
		}
		return dtos;
	}
	@Override
	public CourseDto getById(int id) {
		Course entity = courseRepository.findById(id).get();
		CourseDto dto = new CourseDto();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setContent(entity.getContent());
		dto.setImage(entity.getImage());
		dto.setCate_id(entity.getCate_id());
		dto.setLetures_count(entity.getLetures_count());
		dto.setHour_count(entity.getHour_count());
		dto.setView_count(entity.getView_count());
		dto.setPrice(entity.getPrice());
		dto.setDiscout(entity.getDiscout());
		dto.setPromotion_price(entity.getPromotion_price());
		dto.setLast_update(entity.getLast_update());
		 return dto;
	}
	@Override
	public void insert(CourseDto dto) {
				Course entity = new Course();
				entity.setId(dto.getId());
				entity.setCate_id(dto.getCate_id());
				entity.setContent(dto.getContent());
				entity.setDescription(dto.getDescription());
				entity.setImage(dto.getImage());
				entity.setTitle(dto.getTitle());
				entity.setDiscout(dto.getDiscout());
				entity.setHour_count(dto.getHour_count());
				entity.setLast_update(dto.getLast_update());
				entity.setLetures_count(dto.getLetures_count());
				entity.setPrice(dto.getPrice());
				entity.setPromotion_price(dto.getPromotion_price());
				entity.setView_count(dto.getView_count());
				courseRepository.save(entity);
	}
	@Override
	public void update(int id, CourseDto dto) {
		if(courseRepository.existsById(id)) {
				Course entity = new Course(dto.getId(),dto.getCate_id(),dto.getContent(),dto.getDescription(),dto.getImage(),dto.getTitle()
										,dto.getDiscout(),dto.getHour_count(),dto.getLast_update(),dto.getLetures_count()
										,dto.getPrice(),dto.getPromotion_price(),dto.getView_count())	;
				entity.setId(dto.getId());
				entity.setCate_id(dto.getCate_id());
				entity.setContent(dto.getContent());
				entity.setDescription(dto.getDescription());
				entity.setImage(dto.getImage());
				entity.setTitle(dto.getTitle());
				entity.setDiscout(dto.getDiscout());
				entity.setHour_count(dto.getHour_count());
				entity.setLast_update(dto.getLast_update());
				entity.setLetures_count(dto.getLetures_count());
				entity.setPrice(dto.getPrice());
				entity.setPromotion_price(dto.getPromotion_price());
				entity.setView_count(dto.getView_count());
				courseRepository.save(entity);
				}
		
	}
	@Override
	public void delete(int id) {
		courseRepository.deleteById(id);	
	}

}
