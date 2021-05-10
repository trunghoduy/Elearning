package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;
	 public RoleServiceImpl(RoleRepository roleRepository) {
	this.roleRepository = roleRepository;
	}
	@Override
	public List<RoleDto> getAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		try {
			List<Role> entities = roleRepository.findAll();
			for (Role entity : entities) {
				RoleDto dto = new RoleDto(
						entity.getId(), entity.getName(), entity.getDescription());
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public void insert(RoleDto dto) {
		Role entity = new Role();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		roleRepository.save(entity);
		
	}

	@Override
	public RoleDto getById(int id) {
		Role entity = roleRepository.findById(id).get();
		
		return new RoleDto(entity.getId(), entity.getName(), entity.getDescription());
	}

	@Override
	public void update(int id, RoleDto dto) {
		if(roleRepository.existsById(id)) {
			Role entity = new Role(dto.getId(),dto.getName(),dto.getDescription());
			entity.setName(dto.getName());
			entity.setDescription(dto.getDescription());
			roleRepository.save(entity);
		}	
		
	}

	@Override
	public void delete(int id) {
		 roleRepository.deleteById(id);	

	}

}
