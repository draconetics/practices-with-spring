package com.example.ssi.repository;


import org.springframework.data.repository.CrudRepository;


import com.example.ssi.model.Client;


public interface ClientRepository extends CrudRepository<Client, Long> {
}
