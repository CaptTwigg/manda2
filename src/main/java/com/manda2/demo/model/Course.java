package com.manda2.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nameDK;
  private String nameENG;
  private String programName;
  private boolean meet;
  private int ECTS;
  private String language;
  private int minNumOfStudent;
  private int expNumOfStudent;
  private int maxNumOfStudent;
  private String prerequisites;
  private String learningOutcome;
  private String content;
  private String learningActivitys;
  private String examForm;
  private String teachers;


}
