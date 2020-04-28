package com.mindtree.candyShop.entity;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL ,mappedBy="shop")
	List<Candy> candies=new LinkedList<Candy>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Candy> getCandies() {
		return candies;
	}
	public void setCandies(List<Candy> candies) {
		this.candies = candies;
	}
	
}
