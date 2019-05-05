package com.library.shopbookapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book extends ModelBase{
	
	@NotNull
	//@NotEmpty
	@Size(max = 200)
	private String title;
	
	
	@Size(max = 200)
	private String description;
	
	@NotNull
	//@NotEmpty
	private int year;
	
	
	
	public Book() {}

	public Book(@NotNull @Size(max = 200) String title, @Size(max = 200) String description, @NotNull int year
			) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
	}




	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
}
