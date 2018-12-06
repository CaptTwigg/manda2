package com.manda2.demo.repository;

import com.manda2.demo.model.StudentCourses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentCoursesRepo extends CrudRepository<StudentCourses, Long> {
  StudentCourses findByid(Long id);
  Set<StudentCourses> findAllByPendingTrue();
  Set<StudentCourses> findByPendingTrue();
}
