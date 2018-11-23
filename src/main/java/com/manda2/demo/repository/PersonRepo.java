package com.manda2.demo.repository;

import com.manda2.demo.model.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends CrudRepository<Person, Long> {
  Person findByEmail(String email);
}
