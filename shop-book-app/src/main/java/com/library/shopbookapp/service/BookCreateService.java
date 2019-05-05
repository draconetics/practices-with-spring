package com.library.shopbookapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.shopbookapp.dao.BookCommand;
import com.library.shopbookapp.dao.DetailCommand;
import com.library.shopbookapp.model.Book;
import com.library.shopbookapp.model.Detail;
import com.library.shopbookapp.repository.BookRepository;

@Service
public class BookCreateService {

	private BookCommand bookCommand;
	private DetailCommand detailCommand;
	private Book book;

	@Autowired
	private BookRepository bookRepository;
	
	public BookRepository getBookRepository() {
		return bookRepository;
	}
	
    public void execute(){
    	Book book = composeBookInstance();
    	Detail detail = composeDetailInstance();
    	
    	book.setDetail(detail);
    	detail.setBook(book);
    	
    	//System.out.println(instance.getCreatedOn());
    	this.book = bookRepository.save(book);
    }

    private Book composeBookInstance() {
    	Book instance = new Book();
    	instance.setCreatedOn(new Date());
    	instance.setTitle(this.bookCommand.getTitle());
    	instance.setDescription(this.bookCommand.getDescription());
    	instance.setYear(this.bookCommand.getYear());
    	
    	return instance;
    }
    
    private Detail composeDetailInstance() {
    	Detail detail = new Detail();
    	
    	detail.setCreatedOn(new Date());
    	detail.setCondition(this.bookCommand.getConditionCode());
    	detail.setDescription(this.bookCommand.getDescriptionState());
    	return detail;
    }


    public void setInput(BookCommand bookCommand) {
        this.bookCommand = bookCommand;
    }

    public Book getBook() {
        return this.book;
    }
	
}
