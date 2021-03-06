package com.mindtree.garmentshop.entity;

import java.util.ArrayList;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL ,mappedBy="shop")
	List<Brand> listBrand =new ArrayList<Brand>();
	public Shop()
	{
		
	}
	public Shop(String name, List<Brand> listBrand) {
		this.name = name;
		this.listBrand = listBrand;
	}
	public long getId() {
		return id;
	}
		public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Brand> getListBrand() {
		return listBrand;
	}
	public void setListBrand(List<Brand> listBrand) {
		this.listBrand = listBrand;
	}
	
}
