package com.example.ssi.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.ssi.model.manytoone.PcInternet;


public interface PcInternetRepository extends CrudRepository<PcInternet, Long> {
}
