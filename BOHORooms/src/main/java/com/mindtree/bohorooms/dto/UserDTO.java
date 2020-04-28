package com.mindtree.bohorooms.dto;

import javax.validation.constraints.NotNull;

public class UserDTO {
	private long userId;
	@NotNull(message = "User Name Cannot Be Empty")
	private String userName;
	public UserDTO() {
		super();
	}
	public UserDTO(@NotNull(message = "User Name Cannot Be Empty") String userName) {
		super();
		this.userName = userName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
