package com.library.shopbookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book_detail")
public class Detail extends ModelBase {
	
	
	
	//Available code
	private Integer condition;
	
	@Size(max=200)
	//description book state
	private String description;
	
	

	
	//@OneToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "book_id", nullable = false)
	@OneToOne(mappedBy = "bookDetail")
	private Book book;
	
	public Detail() {}
	
	

	public Detail(Integer condition, @Size(max = 200) String description) {
		super();
		this.condition = condition;
		this.description = description;
	}



	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
