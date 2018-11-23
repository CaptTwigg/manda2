package com.manda2.demo.repository;

import com.manda2.demo.model.Course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
  Course findByid(Long id);
}
