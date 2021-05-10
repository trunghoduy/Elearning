package com.myclass.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.dto.PasswordDto;
import com.myclass.dto.RoleDto;
import com.myclass.dto.UserCourseDto;
import com.myclass.dto.UserDto;
import com.myclass.entity.Category;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	
	 public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	 
	 
	@Override
	public List<UserDto> getAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		try {
		
			List<User> entities = userRepository.findAll();
			for (User entity : entities) {
				UserDto dto = new UserDto();
				dto.setId(entity.getId());
				dto.setAddress(entity.getAddress());
				dto.setAvatar(entity.getAvatar());
				dto.setEmail(entity.getEmail());
				dto.setFullname(entity.getFullname());
				dto.setPassword(entity.getPassword());
				dto.setPhone(entity.getPhone());
				dto.setRole_id(entity.getRole_id());
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	@Override
	public void insert(UserDto dto) {
		try {	
			if(userRepository.findByEmail(dto.getEmail()) == null) {
			String hasher = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
			User entity = new User();
			entity.setAddress(dto.getAddress());
			entity.setAvatar(dto.getAvatar());
			entity.setEmail(dto.getEmail());
			entity.setFullname(dto.getFullname());
			entity.setPassword(hasher);
			entity.setPhone(dto.getPhone());
			entity.setRole_id(dto.getRole_id());	
			userRepository.save(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public UserDto getById(int id) {
	User entity =  userRepository.findById(id).get();
		
		return new UserDto(entity.getId(),entity.getAddress(),entity.getAvatar(), entity.getEmail(),entity.getFullname(),entity.getPassword(),  entity.getPhone(),entity.getRole_id());
	}
	
	
	@Override
	public void update(int id, UserDto dto) {
		String hasher = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
		if(userRepository.existsById(id)) {
			User entity = new User(dto.getId(),dto.getEmail(),
					dto.getFullname(),dto.getPassword(),dto.getAvatar(),
					dto.getPhone(),dto.getAddress(),dto.getRole_id());
			entity.setEmail(dto.getEmail());
			entity.setFullname(dto.getFullname());
			entity.setPassword(hasher);
			entity.setAvatar(dto.getAvatar());
			entity.setAddress(dto.getAddress());
			entity.setPhone(dto.getPhone());
			entity.setRole_id(dto.getRole_id());
			userRepository.save(entity);
		}	
		
	}
	@Override
	public void delete(int id) {
		 userRepository.deleteById(id);
	}
	@Override
	public UserDto getProfile() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		String email = userDetails.getUsername();
		User user =  userRepository.findByEmail(email);
		return new UserDto(user.getId(),user.getEmail(),user.getFullname(),user.getRole_id(), user.getAddress(),user.getPhone(),user.getPassword());
	}
	@Override
	public String changePassword(PasswordDto dto) {
		if(dto.getNewPassword().equals(dto.getOldPassword())) {
			return "Mật khẩu cũ và mới không được trùng nhau!";
		}
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(!BCrypt.checkpw(dto.getOldPassword(), user.getPassword())){
			return "mật khẩu cũ không đúng";
		}
		//mã hóa mật khẩu
		String hasher = BCrypt.hashpw(dto.getNewPassword(), BCrypt.gensalt());
		// cập nhật lại mật khẩu
		user.setPassword(hasher);
		userRepository.save(user);
		return null;
	}


	@Override
	public void saveCourse(UserCourseDto userCourseDto) {
		
		
	}

}
