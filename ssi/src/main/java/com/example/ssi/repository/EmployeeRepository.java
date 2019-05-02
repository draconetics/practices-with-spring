package com.example.ssi.repository;


import org.springframework.data.repository.CrudRepository;


import com.example.ssi.model.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
