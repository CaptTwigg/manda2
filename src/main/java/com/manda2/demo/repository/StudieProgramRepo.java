package com.manda2.demo.repository;

import com.manda2.demo.model.StudieProgram;

import org.springframework.data.repository.CrudRepository;

public interface StudieProgramRepo extends CrudRepository<StudieProgram, Long> {
  StudieProgram findByid(Long id );
}
