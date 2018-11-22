package com.manda2.demo.Controller;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.CourseRepo;
import com.manda2.demo.model.PersonRepo;
import com.manda2.demo.model.StudentRepo;
import com.manda2.demo.model.StudieProgramRepo;
import com.manda2.demo.model.TeacherRepo;
import com.manda2.demo.session.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

  @Autowired
  Auth auth;
  @Autowired
  private StudentRepo studentRepo;
  @Autowired
  private TeacherRepo teacherRepo;
  @Autowired
  private StudieProgramRepo studieProgramRepo;
  @Autowired
  private CourseRepo courseRepo;
  @Autowired
  private PersonRepo personRepo;


  @GetMapping("")
  public String index(){
    return "index";
  }

  @GetMapping("/createCourse")
  public String home(HttpSession httpSession, Model model) {
    if(!auth.isLoggedIn(httpSession)) return "login";

    System.out.println("session id: " + httpSession.getId());

    model.addAttribute("course", new Course());
    model.addAttribute("teachers", teacherRepo.findAll());
    model.addAttribute("studiePrograms", studieProgramRepo.findAll());

//
//    Teacher teacher = new Teacher("teacher1", "mmail@teacher1", "1234", 1);
//    Teacher teacher2 = new Teacher("teacher2", "mmail@teacher2", "1234", 1);
//
//    ArrayList<StudieProgram> studiePrograms = new ArrayList<>(Arrays.asList(
//      new StudieProgram("Computer Science "),
//      new StudieProgram("Web Development"),
//      new StudieProgram("Software development "),
//      new StudieProgram("IT-Security")));
//
//    studieProgramRepo.save(studiePrograms.get(0));
//    studieProgramRepo.save(studiePrograms.get(1));
//    studieProgramRepo.save(studiePrograms.get(2));
//    studieProgramRepo.save(studiePrograms.get(3));
//    teacherRepo.save(teacher);
//    teacherRepo.save(teacher2);
//
//
//    Course course = new Course("Fysik",
//      "physics",
//      3,
//      "classCode123",
//      (List<StudieProgram>) studieProgramRepo.findAll(),
//      true,
//      120,
//      "Dansk",
//      10,
//      30,
//      30,
//      "None",
//      "Pure fysik",
//      "science",
//      "None",
//      "skriftligt",
//      (List<Teacher>) teacherRepo.findAll());
//    Course course2 = new Course();
//    course.setTeachers((List<Teacher>) teacherRepo.findAll());
//    course2.setECTS(240);
//    courseRepo.save(course);
//    courseRepo.save(course2);
//
//
//    studentRepo.save(new Student("Ole", "mail@student1","1234",2, (ArrayList<Course>) courseRepo.findAll()));


    personRepo.findAll().forEach(System.out::println);
    System.out.println();
    courseRepo.findAll().forEach(System.out::println);
    return "courses/createCourse";
  }




  @PostMapping("createCourse")
  public String createCourse(Course course){

    System.out.println("Course: ");
    System.out.println(course);

    return "createCourse";
  }
}
