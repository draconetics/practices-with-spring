package com.library.shopbookapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.shopbookapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
