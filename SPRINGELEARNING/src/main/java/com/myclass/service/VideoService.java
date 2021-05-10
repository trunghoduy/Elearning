package com.myclass.service;

import java.util.List;

import com.myclass.dto.VideoDto;

public interface VideoService {

	List<VideoDto> getByCourseId(int course_id);
}
