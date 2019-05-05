package com.example.ssi.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.ssi.model.onetomany.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
