package com.library.shopbookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.shopbookapp.dao.BookCommand;
//import com.library.shopbookapp.dao.DetailCommand;
import com.library.shopbookapp.model.Book;
//import com.library.shopbookapp.service.BookCreateService;

@RequestMapping(value = "/books")
@RestController
public class BookController {
	/*
	@Autowired
	private BookCreateService bookCreateService;
	
	 @RequestMapping(
			 	value = "/hello",
	            method = RequestMethod.GET)
	public String responseHello() {
		 return "hello, I am a book";
	}
	 
	 @RequestMapping(method = RequestMethod.POST)
	 public Book createBook(@RequestBody BookCommand bookCommand) {
	     bookCreateService.setInput(bookCommand);
	     bookCreateService.execute();
	
	     return bookCreateService.getBook();
	 }*/
}
