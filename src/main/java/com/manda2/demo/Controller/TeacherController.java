package com.manda2.demo.Controller;

import com.manda2.demo.model.Teacher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
public class TeacherController {

  @GetMapping("teachers")
  public String teachers(){
    return "teacher/index";
  }

  @GetMapping("create")
  public String create(Model model){
    model.addAttribute("teacher", new Teacher());
    return "teacher/create";
  }

  @GetMapping("update")
  public String update(){
    return "teacher/update";
  }
}
