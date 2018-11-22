package com.manda2.demo.model;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {


  public Teacher() {
  }

  public Teacher(String name, String email, String password, int niveau) {
    super(name, email, password, niveau);
  }

}
