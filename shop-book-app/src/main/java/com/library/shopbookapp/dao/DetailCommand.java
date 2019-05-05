package com.library.shopbookapp.dao;

import com.library.shopbookapp.model.Book;
import com.library.shopbookapp.model.Detail;
import com.library.shopbookapp.model.ModelBase;

public class DetailCommand extends ModelBase{

	
	private Book book;
	private String description;
	private Integer condition;
	
	public DetailCommand(Detail detail) {
		setId(detail.getId());
        setVersion(detail.getVersion());
        setCreatedOn(detail.getCreatedOn());
        setUpdatedOn(detail.getUpdatedOn());
        
        description = detail.getDescription();
        condition = detail.getCondition();
        book = detail.getBook();
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCondition() {
		return condition;
	}
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	
	
}
