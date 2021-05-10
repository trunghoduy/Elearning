package com.myclass.dto;

import java.util.List;

import com.myclass.entity.Role;
import com.myclass.entity.User;

public class UserDto {

	private int id;
	private String email;
	private String fullname;
	private String password;
	private String avatar;
	private String phone;
	private String address;
	private int role_id;
	private String description;
	private String name;
//	private String token;
	public UserDto() {
		
	}
	public UserDto(int id, String email, String fullname,int role_id, String address,String phone,String password) {
		super();
		this.id = id;
		this.email = email;
		this.fullname = fullname;
		this.role_id = role_id;
		this.address = address;
		this.phone = phone;
		this.password = password;
		
	}
	public UserDto(int id, String address, String avatar, String email, String fullname, String password, String phone,
			int role_id) {
		super();
		this.id = id;
		this.address = address;
		this.avatar = avatar;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.phone = phone;
		this.role_id = role_id;
	}
	public UserDto( String address, String avatar, String email, String fullname,int id, String password, String phone,
			int role_id) {
		super();
		this.address = address;
		this.avatar = avatar;
		this.email = email;
		this.fullname = fullname;
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.role_id = role_id;
	}
	public UserDto( String address, String avatar,String email, String fullname, String password, String phone, 
			int role_id) {
		super();
		this.address = address;
		this.avatar = avatar;
		this.email = email;
		this.fullname = fullname;
		this.password = password;
		this.phone = phone;
		this.role_id = role_id;
	}
	public UserDto(int id, String address, String email, String fullname, String phone, 
			int role_id, String name, String password) {
		super();
		this.id = id;
		this.address = address;	
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
		this.role_id = role_id;
		
		this.description =description;
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public String getToken() {
//		return token;
//	}
//	public void setToken(String token) {
//		this.token = token;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
