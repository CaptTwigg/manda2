package com.manda2.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private String email;
  private int niveau;
  private String position;

  public Person() {
  }

  public Person(String name, String email, int niveau, String position) {
    this.name = name;
    this.email = email;
    this.niveau = niveau;
    this.position = position;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getNiveau() {
    return niveau;
  }

  public void setNiveau(int niveau) {
    this.niveau = niveau;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return String.format("id: %s name: %s email: %s niveau: %s position: %s "
      , this.id, this.name, this.email, this.niveau, this.position);
  }
}
