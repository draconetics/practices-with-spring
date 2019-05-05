package com.example.ssi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ssi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
