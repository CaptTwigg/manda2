package com.manda2.demo.model;

import org.springframework.jmx.export.annotation.ManagedMetric;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Course implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nameDK;
  private String nameENG;
  private int semester;
  private String classCode;
  @ManyToMany
  private List<StudieProgram> studiePrograms;
  private boolean mandatoryOrElective;
  private int ECTS;
  private String courseLanguage;
  private int minNumOfStudent;
  private int expNumOfStudent;
  private int maxNumOfStudent;
  private String prerequisites;
  private String learningOutcome;
  private String content;
  private String learningActivitys;
  private String examForm;
  @ManyToMany
  @JoinColumn(name = "id")
  private List<Teacher> teachers;


  public Course() {
  }

  public Course(String nameDK, String nameENG, int semester, String classCode, List<StudieProgram> studiePrograms, boolean mandatoryOrElective, int ECTS, String courseLanguage, int minNumOfStudent, int expNumOfStudent, int maxNumOfStudent, String prerequisites, String learningOutcome, String content, String learningActivitys, String examForm, List<Teacher> teachers) {
    this.nameDK = nameDK;
    this.nameENG = nameENG;
    this.semester = semester;
    this.classCode = classCode;
    this.studiePrograms = studiePrograms;
    this.mandatoryOrElective = mandatoryOrElective;
    this.ECTS = ECTS;
    this.courseLanguage = courseLanguage;
    this.minNumOfStudent = minNumOfStudent;
    this.expNumOfStudent = expNumOfStudent;
    this.maxNumOfStudent = maxNumOfStudent;
    this.prerequisites = prerequisites;
    this.learningOutcome = learningOutcome;
    this.content = content;
    this.learningActivitys = learningActivitys;
    this.examForm = examForm;
    this.teachers = teachers;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNameDK() {
    return nameDK;
  }

  public void setNameDK(String nameDK) {
    this.nameDK = nameDK;
  }

  public String getNameENG() {
    return nameENG;
  }

  public void setNameENG(String nameENG) {
    this.nameENG = nameENG;
  }

  public List<StudieProgram> getStudiePrograms() {
    return studiePrograms;
  }

  public void setStudiePrograms(List<StudieProgram> studiePrograms) {
    this.studiePrograms = studiePrograms;
  }

  public boolean isMandatoryOrElective() {
    return mandatoryOrElective;
  }

  public void setMandatoryOrElective(boolean mandatoryOrElective) {
    this.mandatoryOrElective = mandatoryOrElective;
  }

  public int getECTS() {
    return ECTS;
  }

  public void setECTS(int ECTS) {
    this.ECTS = ECTS;
  }

  public String getCourseLanguage() {
    return courseLanguage;
  }

  public void setCourseLanguage(String courseLanguage) {
    this.courseLanguage = courseLanguage;
  }

  public int getMinNumOfStudent() {
    return minNumOfStudent;
  }

  public void setMinNumOfStudent(int minNumOfStudent) {
    this.minNumOfStudent = minNumOfStudent;
  }

  public int getExpNumOfStudent() {
    return expNumOfStudent;
  }

  public void setExpNumOfStudent(int expNumOfStudent) {
    this.expNumOfStudent = expNumOfStudent;
  }

  public int getMaxNumOfStudent() {
    return maxNumOfStudent;
  }

  public void setMaxNumOfStudent(int maxNumOfStudent) {
    this.maxNumOfStudent = maxNumOfStudent;
  }

  public String getPrerequisites() {
    return prerequisites;
  }

  public void setPrerequisites(String prerequisites) {
    this.prerequisites = prerequisites;
  }

  public String getLearningOutcome() {
    return learningOutcome;
  }

  public void setLearningOutcome(String learningOutcome) {
    this.learningOutcome = learningOutcome;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getLearningActivitys() {
    return learningActivitys;
  }

  public void setLearningActivitys(String learningActivitys) {
    this.learningActivitys = learningActivitys;
  }

  public String getExamForm() {
    return examForm;
  }

  public void setExamForm(String examForm) {
    this.examForm = examForm;
  }

  public List<Teacher> getTeachers() {
    return teachers;
  }

  public void setTeachers(List<Teacher> teachers) {
    this.teachers = teachers;
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(int semester) {
    this.semester = semester;
  }

  public String getClassCode() {
    return classCode;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }

  @Override
  public String toString() {
    return String.format("id: %s nameDK: %s nameENG: %s semester: %s classCode: %s studiePrograms: %s mandatoryOrElective: %s ECTS: %s courseLanguage: %s minNumOfStudent: %s expNumOfStudent: %s maxNumOfStudent: %s prerequisites: %s learningOutcome: %s content: %s learningActivitys: %s examForm: %s teachers: %s "
      , this.id, this.nameDK, this.nameENG, this.semester, this.classCode, this.studiePrograms, this.mandatoryOrElective, this.ECTS, this.courseLanguage, this.minNumOfStudent, this.expNumOfStudent, this.maxNumOfStudent, this.prerequisites, this.learningOutcome, this.content, this.learningActivitys, this.examForm, this.teachers);
  }
}
