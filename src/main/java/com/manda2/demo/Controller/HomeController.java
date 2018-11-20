package com.manda2.demo.Controller;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.CourseRepo;
import com.manda2.demo.model.Student;
import com.manda2.demo.model.StudentRepo;
import com.manda2.demo.model.StudieProgram;
import com.manda2.demo.model.StudieProgramRepo;
import com.manda2.demo.model.Teacher;
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

  @Autowired
  private StudieProgramRepo studieProgramRepo;

  @GetMapping("")
  public String home() {

    Teacher teacher = new Teacher("teacher1","mail",1,"teacher");
    Teacher teacher2 = new Teacher("teacher2","mail",1,"teacher");

    ArrayList<StudieProgram> studiePrograms = new ArrayList<>(Arrays.asList(
      new StudieProgram("Computer Science "),
      new StudieProgram("Web Development"),
      new StudieProgram("Software development "),
      new StudieProgram("IT-Security")));

    studieProgramRepo.save(studiePrograms.get(0));
    studieProgramRepo.save(studiePrograms.get(1));
    studieProgramRepo.save(studiePrograms.get(2));
    studieProgramRepo.save(studiePrograms.get(3));
    teacherRepo.save(teacher);
    teacherRepo.save(teacher2);


    Course course = new Course("Fysik",
      "physics",
      (List<StudieProgram>) studieProgramRepo.findAll(),
      true,
      120,
      "Dansk",
      10,
      30 ,
      30,
      "None",
      "Pure fysik",
      "science",
      "None",
      "skriftligt",
      (List<Teacher>) teacherRepo.findAll());
    Course course2 = new Course();
    course.setTeachers((List<Teacher>) teacherRepo.findAll());
    course2.setECTS(240);
    courseRepo.save(course);
    courseRepo.save(course2);


    studentRepo.save(new Student("Ole", "mail", 2, "student", (ArrayList<Course>) courseRepo.findAll()));


    courseRepo.findAll().forEach(System.out::println);
    return "index";
  }
}
