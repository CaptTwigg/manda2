package com.manda2.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudieProgram {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String program;


  public StudieProgram() {
  }

  public StudieProgram( String program) {
    this.program = program;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  @Override
  public String toString() {
    return String.format("id: %s program: %s "
      , this.id, this.program);
  }
}
