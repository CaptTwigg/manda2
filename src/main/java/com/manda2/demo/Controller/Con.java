package com.manda2.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Con {

  @GetMapping("")
  public String ss(){
    return "course/index";
  }
}
