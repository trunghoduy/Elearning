package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myclass.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {

//	@Query("SELECT v FROM Video v WHERE course_id = : courseId")
	List<Video> findByCourseId( int course_id);
}
