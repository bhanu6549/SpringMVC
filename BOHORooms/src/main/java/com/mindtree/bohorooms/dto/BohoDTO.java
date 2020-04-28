package com.mindtree.bohorooms.dto;

import javax.validation.constraints.NotNull;

public class BohoDTO {
	private long bohoId;
	@NotNull(message = "Boho Name Cannot Be Empty")
	private String bohoName;
	private float rating;
	
	public BohoDTO() {
		
	}

	public BohoDTO(long bohoId, @NotNull(message = "Boho Name Cannot Be Empty") String bohoName) {
		super();
		this.bohoId = bohoId;
		this.bohoName = bohoName;
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

}
