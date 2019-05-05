package com.library.shopbookapp.dao;

import com.library.shopbookapp.model.Book;
import com.library.shopbookapp.model.ModelBase;

public class BookCommand extends ModelBase{
	
	
	private String title;
	private String description;
	private Integer year;
	private String descriptionState;
	private Integer conditionCode;
	
	public BookCommand (Book book) {
        setId(book.getId());
        setVersion(book.getVersion());
        setCreatedOn(book.getCreatedOn());
        setUpdatedOn(book.getUpdatedOn());
        
        title = book.getTitle();
        description = book.getDescription();
        year = book.getYear();
        
        descriptionState = book.getDetail().getDescription();
        conditionCode = book.getDetail().getCondition();
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

	public String getDescriptionState() {
		return descriptionState;
	}

	public void setDescriptionState(String descriptionState) {
		this.descriptionState = descriptionState;
	}

	public Integer getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(Integer conditionCode) {
		this.conditionCode = conditionCode;
	}
	
	
}
