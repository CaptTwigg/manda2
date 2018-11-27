package com.manda2.demo.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.manda2.demo.model.Teacher;
import com.manda2.demo.repository.TeacherRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeacherRestController {


  @Autowired
  TeacherRepo teacherRepo;

//  @GetMapping("SearchTeacher")
//  public ResponseEntity search(@RequestParam String name){
//
//    List<Teacher> teacherList = teacherRepo.findAllByNameContaining(name);
//    List<HashMap> hashMaps = new ArrayList<>();
//
//    for (Teacher teacher : teacherList) {
//      HashMap hashMap = new HashMap<>();
//      System.out.println(teacher.getName());
//      hashMap.put("name", teacher.getName());
//      hashMaps.add( hashMap);
//    }
//    System.out.println(hashMaps);
//
//    return new ResponseEntity<>(hashMaps, HttpStatus.OK);
//
//  }

  @GetMapping("teacherByName")
  public ResponseEntity search(){

    List<Teacher> teacherList = (List<Teacher>) teacherRepo.findAll();
    List<HashMap> hashMaps = new ArrayList<>();

    for (Teacher teacher : teacherList) {
      HashMap hashMap = new HashMap<>();
      hashMap.put("id", teacher.getId());
      hashMap.put("name", teacher.getName());
      hashMap.put("email", teacher.getEmail());
      hashMaps.add( hashMap);
    }

    return new ResponseEntity<>(hashMaps, HttpStatus.OK);
  }

  @PostMapping("create")
  public ResponseEntity create(Teacher teacher){
    if (teacher == null) return new ResponseEntity<>("No info given", HttpStatus.NO_CONTENT);
    String okRespond = String.format("Teacher: %s created", teacher);
    teacherRepo.save(teacher);
    return new ResponseEntity<>(okRespond, HttpStatus.OK);
  }
}
