package com.manda2.demo.repository;

import com.manda2.demo.model.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
  Student findByid(Long id);
}
