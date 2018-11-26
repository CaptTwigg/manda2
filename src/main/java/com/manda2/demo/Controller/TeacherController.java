package com.manda2.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherController {

  @GetMapping("teachers")
  public String teachers(){
    return "teacher/index";
  }
}
