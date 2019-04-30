package com.demo.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.demo.hospital.model.Doctor;


public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
