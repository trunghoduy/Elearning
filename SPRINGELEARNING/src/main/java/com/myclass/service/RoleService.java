package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;

public interface RoleService {

	List<RoleDto> getAll();

	void insert(RoleDto dto);

	RoleDto getById(int id);

	void update(int id, RoleDto dto);

	void delete(int id);

}
