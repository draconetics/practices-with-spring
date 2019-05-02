package com.example.ssi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.ssi.model.Clas;


public interface ClasRepository extends CrudRepository<Clas, Long> {
}
