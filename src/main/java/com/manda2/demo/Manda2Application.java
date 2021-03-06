package com.manda2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.manda2.demo.repository")
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
