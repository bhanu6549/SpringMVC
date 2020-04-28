package com.mindtree.bohorooms.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class BOHO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bohoId;
	private String bohoName;
	private float rating;
	
	@OneToMany(mappedBy = "boho", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Room> rooms;

	public BOHO() {
		
	}

	public BOHO(String bohoName, float rating, List<Room> rooms) {
		super();
		this.bohoName = bohoName;
		this.rating = rating;
		this.rooms = rooms;
	}

	public long getBohoId() {
		return bohoId;
	}

	public void setBohoId(long bohoId) {
		this.bohoId = bohoId;
	}

	public String getBohoName() {
		return bohoName;
	}

	public void setBohoName(String bohoName) {
		this.bohoName = bohoName;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bohoName == null) ? 0 : bohoName.hashCode());
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
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
		BOHO other = (BOHO) obj;
		if (bohoName == null) {
			if (other.bohoName != null)
				return false;
		} else if (!bohoName.equals(other.bohoName))
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BOHO [bohoId=" + bohoId + ", bohoName=" + bohoName + ", rating=" + rating + ", rooms=" + rooms + "]";
	}
}