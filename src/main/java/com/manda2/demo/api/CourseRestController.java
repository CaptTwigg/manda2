package com.manda2.demo.api;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.CourseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CourseRestController {

  @Autowired
  private CourseRepo courseRepo;

  @PostMapping("createCourse")
  public ResponseEntity createCourse(Course course){
    System.out.println(course);
    courseRepo.save(course);


    return new ResponseEntity<>("Car created", HttpStatus.OK);
  }
}
