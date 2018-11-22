package com.manda2.demo.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @Column(name = "verynicename")
  private String name;
  private String email;
  private String password;
  private int niveau;


  public Person() {
  }

  public Person(String name, String email, String password, int niveau) {
    this.name = name;
    this.email = email;
    this.password = new BCryptPasswordEncoder().encode(password);
    this.niveau = niveau;
  }

  @Override
  public String toString() {
    return String.format("id: %s name: %s email: %s password: %s niveau: %s "
      , this.id, this.name, this.email, this.password, this.niveau);
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getNiveau() {
    return niveau;
  }

  public void setNiveau(int niveau) {
    this.niveau = niveau;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
