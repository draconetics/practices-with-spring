package com.library.shopbookapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Area extends ModelBase{

	private String name;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( unique=true, nullable=true)
	private Category category;
	
	
	public Area() {}


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
	
	
}
