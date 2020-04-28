package com.mindtree.bohorooms.dto;

public class BohoUserDTO {
private long userId;
private String userName;
private long bohoId;
private float rating;
private String bohoName;
public BohoUserDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public BohoUserDTO(long userId, String userName, long bohoId, float rating, String bohoName) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.bohoId = bohoId;
	this.rating = rating;
	this.bohoName = bohoName;
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
public long getBohoId() {
	return bohoId;
}
public void setBohoId(long bohoId) {
	this.bohoId = bohoId;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public String getBohoName() {
	return bohoName;
}
public void setBohoName(String bohoName) {
	this.bohoName = bohoName;
}

}
