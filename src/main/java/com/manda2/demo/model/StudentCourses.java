package com.manda2.demo.model;

import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class StudentCourses {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "student_course_id")
  private Long id;

  @ManyToOne
  @JoinColumn(referencedColumnName = "id", name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(referencedColumnName = "id", name = "course_id")
  private Course course;

  @CreationTimestamp
  private Date timestamp;

  @Column(name = "accepted", columnDefinition = "tinyint(1) default 0")
  private boolean accepted;
  @Column(name = "pending", columnDefinition = "tinyint(1) default 1")
  private boolean pending;


  public StudentCourses() {
  }

  public StudentCourses(Student student, Course course) {
    this.student = student;
    this.course = course;
  }

  public StudentCourses(Student student, Course course, Date timestamp) {
    this.student = student;
    this.course = course;
    this.timestamp = timestamp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isAccepted() {
    return accepted;
  }

  public void setAccepted(boolean accepted) {
    this.accepted = accepted;
  }

  public boolean isPending() {
    return pending;
  }

  public void setPending(boolean pending) {
    this.pending = pending;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }



  @Override
  public String toString() {
    return String.format("id: %s studentID: %s courseID: %s timestamp: %s accepted: %s pending: %s "
      , this.id, this.student.getId(), this.course.getId(), this.timestamp, this.accepted, this.pending);
  }
}
