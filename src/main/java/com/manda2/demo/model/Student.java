package com.manda2.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Student extends Person {

  @ManyToMany
  @JoinColumn(name = "id")
  List<Course> courses;

  public Student() {
  }

  public Student(String name, String email, String password, int niveau, List<Course> courses) {
    super(name, email, password, niveau);
    this.courses = courses;
  }

  @Override
  public String toString() {
    return String.format("course: %s id: %s name: %s"
      , this.courses, getId(), getName());
  }
}
