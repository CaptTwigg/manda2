package com.manda2.demo.api;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.Student;
import com.manda2.demo.model.StudentCourses;
import com.manda2.demo.repository.CourseRepo;
import com.manda2.demo.repository.StudentCoursesRepo;
import com.manda2.demo.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentRestController {

  @Autowired
  StudentCoursesRepo studentCoursesRepo;

  @Autowired
  StudentRepo studentRepo;

  @Autowired
  CourseRepo courseRepo;

  @PostMapping("add/studentCourse")
  public ResponseEntity add(@RequestParam Long courseID) {
    Student student = studentRepo.findByid((long) 9);
    Course course = courseRepo.findByid(courseID);
    if (course == null)
      return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);

    StudentCourses studentCourses = new StudentCourses(student, course);
    studentCoursesRepo.save(studentCourses);

    return new ResponseEntity<>(String.format("Student: %s joined Course: %S", student.getName(), course.getClassCode()), HttpStatus.OK);
  }
}
