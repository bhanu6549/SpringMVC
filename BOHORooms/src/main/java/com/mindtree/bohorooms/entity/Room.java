package com.mindtree.bohorooms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roomId;
	private String roomName;
	private int cost;
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	
	private BOHO boho;
	@OneToOne(cascade = {CascadeType.ALL})
	
	private User user;
	public Room() {
		super();
		
	}
	public Room(String roomName, int cost, int quantity, BOHO boho, User user) {
		super();
		this.roomName = roomName;
		this.cost = cost;
		this.quantity = quantity;
		this.boho = boho;
		this.user = user;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BOHO getBoho() {
		return boho;
	}
	public void setBoho(BOHO boho) {
		this.boho = boho;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boho == null) ? 0 : boho.hashCode());
		result = prime * result + cost;
		result = prime * result + quantity;
		result = prime * result + (int) (roomId ^ (roomId >>> 32));
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (boho == null) {
			if (other.boho != null)
				return false;
		} else if (!boho.equals(other.boho))
			return false;
		if (cost != other.cost)
			return false;
		if (quantity != other.quantity)
			return false;
		if (roomId != other.roomId)
			return false;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", cost=" + cost + ", quantity=" + quantity
				+ ", boho=" + boho + ", user=" + user + "]";
	}
	
	
	
}