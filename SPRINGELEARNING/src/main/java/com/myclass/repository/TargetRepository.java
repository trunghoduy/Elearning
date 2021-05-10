package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Target;

public interface TargetRepository extends JpaRepository<Target, Integer> {

	List<Target> findByCourseId( int course_id);
}
