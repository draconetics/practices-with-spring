package com.library.shopbookapp.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DetailBook extends ModelBase {
	
	private int numberPages;
	private String stateBook;
	private int codeState;
	
	@OneToOne
	@JoinColumn(name = "book_id", unique = true)
	private Book book;

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}

	public String getStateBook() {
		return stateBook;
	}

	public void setStateBook(String stateBook) {
		this.stateBook = stateBook;
	}

	public int getCodeState() {
		return codeState;
	}

	public void setCodeState(int codeState) {
		this.codeState = codeState;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
