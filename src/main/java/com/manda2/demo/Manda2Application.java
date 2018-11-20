package com.manda2.demo;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.Student;
import com.manda2.demo.model.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class Manda2Application  extends SpringBootServletInitializer {


  @Override
  protected SpringApplicationBuilder configure(
    SpringApplicationBuilder builder) {
    return builder.sources(Manda2Application.class);
  }


  public static void main(String[] args) {
    SpringApplication.run(Manda2Application.class, args);
  }
}
