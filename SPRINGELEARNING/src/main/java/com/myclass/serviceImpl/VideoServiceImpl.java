package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.VideoDto;
import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
import com.myclass.service.VideoService;

@Service
@Transactional(rollbackOn = Exception.class)
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoRepository videoRepository;
	@Override
	public List<VideoDto> getByCourseId(int course_id) {
		List<VideoDto> videoDtos = new ArrayList<VideoDto>();
		List<Video> entities= videoRepository.findByCourseId(course_id);
		for (Video entity : entities) {
			VideoDto dto = new VideoDto();
			dto.setId(entity.getId());
			dto.setTitle(entity.getTitle());
			dto.setUrl(entity.getUrl());
			dto.setTimeCout(entity.getTimeCout());
			dto.setCourse_id(entity.getCourse_id());
			videoDtos.add(dto);
		}
		return videoDtos;
	}

}
