package com.manda2.demo.Controller;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.CourseRepo;
import com.manda2.demo.model.Student;
import com.manda2.demo.model.StudentRepo;
import com.manda2.demo.model.TeacherRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

  @Autowired
  private StudentRepo studentRepo;

  @Autowired
  private TeacherRepo teacherRepo;

  @Autowired
  private CourseRepo courseRepo;

  @GetMapping("")
  public String home() {
    Course course = new Course();
    Course course2 = new Course();
    course.setECTS(120);
    course2.setECTS(240);
    courseRepo.save(course);
    courseRepo.save(course2);
    studentRepo.save(new Student("Ole", "mail", 2, "student", (ArrayList<Course>) courseRepo.findAll()));


    courseRepo.findAll().forEach(System.out::println);
    return "index";
  }
}
