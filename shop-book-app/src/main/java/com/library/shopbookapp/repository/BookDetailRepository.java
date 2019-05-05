package com.library.shopbookapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.shopbookapp.model.DetailBook;

public interface BookDetailRepository extends CrudRepository<DetailBook, Long>{

}
