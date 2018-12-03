package com.manda2.demo.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Student extends Person {



  @OneToMany(mappedBy = "student")
  private Set<StudentCourses> studentCoursesSet = new HashSet<>();


  public Student() {
  }

  public Student(String name, String email, String password, int niveau) {
    super(name, email, password, niveau);
  }

  public Set<StudentCourses> getStudentCoursesSet() {
    return studentCoursesSet;
  }

  public void setStudentCoursesSet(Set<StudentCourses> studentCoursesSet) {
    this.studentCoursesSet = studentCoursesSet;
  }

  @Override
  public String toString() {
    return String.format("id: %s name: %s Course: %s"
      , getId(), getName(), studentCoursesSet);
  }
}
