package com.example.ssi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.ssi.model.manytomany.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
}
