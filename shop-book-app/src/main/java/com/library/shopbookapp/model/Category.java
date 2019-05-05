package com.library.shopbookapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Category extends ModelBase{
	
	private String name;
	private String description;
	
	//@OneToOne(targetEntity = Area.class)
	@ManyToOne
	@JoinColumn(name = "area_id", nullable=false)
	private Area area;
	
	@OneToMany(mappedBy="category")
    private Set<Book> books;
	
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
