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
@Table(name = "books")
public class Book extends ModelBase{
	
	@NotNull
	//@NotEmpty
	@Size(max = 200)
	private String title;
	
	
	@Size(max = 200)
	private String description;
	
	@NotNull
	//@NotEmpty
	private Integer year;
	
	
//	 @OneToOne(fetch = FetchType.LAZY,
//	            cascade =  CascadeType.ALL,
//	            mappedBy = "book")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail_id",nullable=true)
	private Detail bookDetail;
	
	public Book() {}

	public Book(@NotNull @Size(max = 200) String title, @Size(max = 200) String description, @NotNull Integer year,
			Detail bookDetail) {
		super();
		this.title = title;
		this.description = description;
		this.year = year;
		this.bookDetail = bookDetail;
		this.bookDetail.setBook(this);
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Detail getDetail() {
		return bookDetail;
	}

	public void setDetail(Detail detail) {
		this.bookDetail = detail;
	}
	

	
}
