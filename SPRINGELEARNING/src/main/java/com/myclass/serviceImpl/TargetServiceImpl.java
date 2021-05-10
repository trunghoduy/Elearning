package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.TargetDto;
import com.myclass.entity.Target;
import com.myclass.repository.TargetRepository;
import com.myclass.service.TargetService;

@Service
@Transactional(rollbackOn = Exception.class)
public class TargetServiceImpl implements TargetService{

	@Autowired
	private TargetRepository targetRepository;
	@Override
	public List<TargetDto> getByCourseId(int count_id) {
		List<TargetDto> targetDtos = new ArrayList<TargetDto>();
		List<Target> entities = targetRepository.findByCourseId(count_id);
		for (Target entity : entities) {
			TargetDto dto = new TargetDto();
			dto.setId(entity.getId());
			dto.setCourse_id(entity.getCourse_id());
			dto.setTitle(entity.getTitle());
			targetDtos.add(dto);
		}
		return targetDtos;
	}

}
