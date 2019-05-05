package com.example.ssi.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ssi.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
