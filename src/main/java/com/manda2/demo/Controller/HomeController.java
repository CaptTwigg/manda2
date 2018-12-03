package com.manda2.demo.Controller;

import com.manda2.demo.model.Course;
import com.manda2.demo.model.Student;
import com.manda2.demo.model.StudentCourses;
import com.manda2.demo.model.StudieProgram;
import com.manda2.demo.model.Teacher;
import com.manda2.demo.repository.CourseRepo;
import com.manda2.demo.repository.PersonRepo;
import com.manda2.demo.repository.StudentCoursesRepo;
import com.manda2.demo.repository.StudentRepo;
import com.manda2.demo.repository.StudieProgramRepo;
import com.manda2.demo.repository.TeacherRepo;
import com.manda2.demo.session.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("course")
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

  @Autowired
  private StudentCoursesRepo studentCoursesRepo;


  @GetMapping("")
  public String index() {
    Student student = studentRepo.findByid((long) 9);
    Course course = courseRepo.findByid((long) 8);
    System.out.println(student);
    System.out.println(course);
    //studentCoursesRepo.save(new StudentCourses(student,course));
    //ArrayList<StudentCourses> studentCourses = (ArrayList<StudentCourses>) studentCoursesRepo.findAll();
    Set<StudentCourses> studentCourses = studentCoursesRepo.findByid((long) 20);
    System.out.println(studentCourses);

    student.setStudentCoursesSet(studentCourses);
    studentRepo.save(student);
    System.out.println(student.getStudentCoursesSet());
    System.out.println(studentRepo.findAll());
    return "index";
  }

  @GetMapping("/createCourse")
  public String home(HttpSession httpSession, Model model) {
   // if (!auth.isLoggedIn(httpSession)) return "login";
    model.addAttribute("course", new Course());
    model.addAttribute("teachers", teacherRepo.findAll());
    model.addAttribute("studiePrograms", studieProgramRepo.findAll());


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
//      studieProgramRepo.findByid((long) 1),
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
//    studentRepo.save(new Student("Ole", "mail@student1", "1234", 2, (ArrayList<Course>) courseRepo.findAll()));
    return "course/createCourse";
  }

  @GetMapping("courses")
  public String courses() {
    return "course/index";
  }

  @GetMapping("updateCourse/{id}")
  public String update(Model model, @PathVariable Long id){
    Course course = courseRepo.findByid(id);
    model.addAttribute("course", course);
    model.addAttribute("teachers", teacherRepo.findAll());
    model.addAttribute("studiePrograms", studieProgramRepo.findAll());
    return "course/update";
  }
}
