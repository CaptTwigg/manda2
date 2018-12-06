package com.manda2.demo.api;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.Teacher;
import com.manda2.demo.repository.CourseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/course")
public class CourseRestController {

  @Autowired
  private CourseRepo courseRepo;

  @GetMapping("courses")
  public ResponseEntity showall() {
    List courses = new ArrayList();
    try {
      courses = (List) courseRepo.findAll();
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(courses, HttpStatus.OK);
  }

  @GetMapping("course")
  public ResponseEntity course(@RequestParam Long id){
    Course course;
    try {
      course = courseRepo.findByid(id);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(course, HttpStatus.OK);
  }

  @PostMapping("createCourse")
  public ResponseEntity createCourse(Course course) {
    if (course == null) return new ResponseEntity<>("No info given", HttpStatus.NO_CONTENT);
    String okRespond = String.format("Course: %s created", course);
    courseRepo.save(course);
    return new ResponseEntity<>(okRespond, HttpStatus.OK);
  }

  @PutMapping("updateCourse")
  public ResponseEntity updateCourse(Course course) {
    if (course == null) return new ResponseEntity<>("No info given", HttpStatus.NO_CONTENT);
    String okRespond = String.format("Course: %s updated", course);
    courseRepo.save(course);

    return new ResponseEntity<>(okRespond, HttpStatus.OK);
  }

  @DeleteMapping("deleteCourse")
  public ResponseEntity delete(Course course){
    if (course == null) return new ResponseEntity<>("No info given", HttpStatus.NO_CONTENT);
    String okRespond = String.format("Course: %s deleted", course);
    courseRepo.delete(course);
    return new ResponseEntity<>(okRespond, HttpStatus.OK);
  }

  @GetMapping("courseTeachers")
  public ResponseEntity teachers(@RequestParam Long id){
    Course course = courseRepo.findByid(id);
    List<Teacher> teachers = course.getTeachers();

    return new ResponseEntity<>(teachers, HttpStatus.OK);
  }

}
