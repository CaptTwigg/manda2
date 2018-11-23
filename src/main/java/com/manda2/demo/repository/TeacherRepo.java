package com.manda2.demo.repository;

import com.manda2.demo.model.Teacher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Long> {
}
