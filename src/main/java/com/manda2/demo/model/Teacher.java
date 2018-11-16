package com.manda2.demo.model;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {


  public Teacher() {
  }

  public Teacher(String name, String email, int niveau, String position) {
    super(name, email, niveau, position);
  }


}
