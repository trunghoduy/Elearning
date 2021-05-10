package com.myclass.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDetailsDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		// gọi hàm kiểm tra emaill
		User user = userRepository.findByEmail(email);
		if(user==null) throw new UsernameNotFoundException("email không tồn tại!");
		//tạo danh sách chưa tên quyền gười dùng
		String rolename =  user.getRole().getName();
		
		List<GrantedAuthority> authorities =  new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority(rolename));
		
		
		// trả về đối tượng có kiểu dữ liêu UserDatails
		UserDetails userDetails = new UserDetailsDto(user.getEmail(), user.getPassword(), authorities);
		return userDetails;
	}

}
