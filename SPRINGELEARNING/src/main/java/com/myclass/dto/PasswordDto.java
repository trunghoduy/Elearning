package com.myclass.dto;

public class PasswordDto {

	private String newPassword;
	private String oldPassword;
	private String email;
	
	public PasswordDto() {
		
	}

	public PasswordDto(String newPassword, String oldPassword, String email) {
		super();
		this.newPassword = newPassword;
		this.oldPassword = oldPassword;
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
