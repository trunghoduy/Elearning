package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.dto.CourseDetailsDto;
import com.myclass.dto.CourseDto;
import com.myclass.dto.TargetDto;
import com.myclass.dto.VideoDto;
import com.myclass.service.CourseService;
import com.myclass.service.TargetService;
import com.myclass.service.VideoService;

@Controller
@RequestMapping("api/course")
public class CourseController {

	@Autowired
	public CourseService courseService;
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private TargetService targetService;

	@GetMapping("")
	public Object get() {
		try {

			List<CourseDto> courseDtos = courseService.getAll();
			return new ResponseEntity<Object>(courseDtos, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	public Object get(@PathVariable int id) {
		try {

			CourseDto courseDto = courseService.getById(id);
			List<VideoDto> videoDtos = videoService.getByCourseId(id);
			List<TargetDto> targetDtos = targetService.getByCourseId(id);
			// lamf taget giong video
			
			courseDto.setVideo(videoDtos);
			courseDto.setTarget(targetDtos);
			return new ResponseEntity<Object>(courseDto, HttpStatus.OK);// thay vì đóng gói
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}
