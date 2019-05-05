package com.library.shopbookapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.shopbookapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
