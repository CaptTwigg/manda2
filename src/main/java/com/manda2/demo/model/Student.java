package com.manda2.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student extends Person {

  @ManyToMany
  @JoinColumn(name = "id")
  List<Course> courses;

  public Student() {
  }

  public Student(String name, String email, int niveau, String position, ArrayList<Course> courses) {
    super(name, email, niveau, position);
    this.courses = courses;
  }

  @Override
  public String toString() {
    return String.format("courses: %s id: %s name: %s"
      , this.courses, getId(), getName());
  }
}
