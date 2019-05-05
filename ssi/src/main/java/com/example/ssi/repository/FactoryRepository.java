package com.example.ssi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.ssi.model.manytomany.Clas;
import com.example.ssi.model.onetomany.Factory;


public interface FactoryRepository extends CrudRepository<Factory, Long> {
}
