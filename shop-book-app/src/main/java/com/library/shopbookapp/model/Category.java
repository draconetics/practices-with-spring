package com.library.shopbookapp.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Category extends ModelBase{
	
	private String name;
	private String description;
	
	@OneToOne(targetEntity = Area.class)
	private Area area;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	
}
