package com.mindtree.bohorooms.dto;

import javax.validation.constraints.NotNull;

public class RoomDTO {
	private long roomId;
	@NotNull(message = "Room Name Cannot Be Empty")
	private String roomName;
	@NotNull(message = "Room cost Cannot Be Empty")
	private float cost;
	public RoomDTO() {
		super();
	}
	public RoomDTO(@NotNull(message = "Room Name Cannot Be Empty") String roomName,
			@NotNull(message = "Room cost Cannot Be Empty") float cost) {
		super();
		this.roomName = roomName;
		this.cost = cost;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
}
