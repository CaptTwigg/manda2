package com.manda2.demo.api;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.Student;
import com.manda2.demo.model.StudentCourses;
import com.manda2.demo.model.Teacher;
import com.manda2.demo.repository.CourseRepo;
import com.manda2.demo.repository.StudentCoursesRepo;
import com.manda2.demo.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  @GetMapping("pending")
  public ResponseEntity pending() {


    HashSet<StudentCourses> list = (HashSet<StudentCourses>) studentCoursesRepo.findByPendingTrue();
    List<HashMap> hashMaps = new ArrayList<>();

    for (StudentCourses sc : list) {
      HashMap hashMap = new HashMap<>();
      hashMap.put("id", sc.getId());
      hashMap.put("studentName", sc.getStudent().getName());
      hashMap.put("course", sc.getCourse());
      hashMap.put("timestamp", sc.getTimestamp());
      hashMap.put("accepted", sc.isAccepted());
      hashMap.put("pending", sc.isPending());
      hashMaps.add(hashMap);
    }
    return new ResponseEntity<>(hashMaps, HttpStatus.OK);
  }


  @PutMapping("updatePending")
  public ResponseEntity update(@RequestParam Long courseID, @RequestParam boolean acc) {
    StudentCourses studentCourses = studentCoursesRepo.findByid(courseID);
    studentCourses.setPending(false);
    studentCourses.setAccepted(acc);
    System.out.println(studentCourses);

    studentCoursesRepo.save(studentCourses);
    return new ResponseEntity<>("", HttpStatus.OK);
  }
}
